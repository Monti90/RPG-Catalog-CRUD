package wasko.collectionmanager.rpgcollection.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.repositories.UserRepository;

import java.util.Collections;

@Service
@AllArgsConstructor
public class LoginDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final  String username) {
        UserEntity userEntity = userRepository.findByuserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return new User(
                userEntity.getUserName(),
                userEntity.getUserPassword(),
                Collections.singleton(new SimpleGrantedAuthority(userEntity.getRole().toString())));
    }
}