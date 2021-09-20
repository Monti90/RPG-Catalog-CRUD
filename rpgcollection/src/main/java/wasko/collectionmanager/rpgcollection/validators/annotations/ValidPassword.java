package wasko.collectionmanager.rpgcollection.validators.annotations;

import wasko.collectionmanager.rpgcollection.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {PasswordValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Jakis komentarz";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
