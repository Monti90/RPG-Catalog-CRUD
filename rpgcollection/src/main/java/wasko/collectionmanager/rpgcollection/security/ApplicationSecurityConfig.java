package wasko.collectionmanager.rpgcollection.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import wasko.collectionmanager.rpgcollection.services.LoginDetailsService;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private PasswordEncoder passwordEncoder;
    private LoginDetailsService loginDetailsService;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private JwtRequestFilter jwtRequestFilter;

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(loginDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/game", "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/authenticate")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
        .and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(loginDetailsService);
        return provider;
    }

    @Bean
    public DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(){
        return new DefaultAuthenticationEventPublisher();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        auth.authenticationEventPublisher(defaultAuthenticationEventPublisher());
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        // likely you should limit this to specific origins
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("X-XSRF-TOKEN");
        config.addAllowedHeader("x-requested-with");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("X-Pagination-Total-Pages");
        config.addAllowedHeader("X-Pagination-Total-Entries");
        config.addAllowedHeader("X-Pagination-Current-Page");
        config.addAllowedHeader("X-Pagination-Per-Page");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
