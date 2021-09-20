package wasko.collectionmanager.rpgcollection.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    @NotBlank(message = "username should not be empty")
    private String userName;
    @NotBlank(message = "password should not be empty")
    private String userPassword;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Role should not be empty")
    private String role;
}
