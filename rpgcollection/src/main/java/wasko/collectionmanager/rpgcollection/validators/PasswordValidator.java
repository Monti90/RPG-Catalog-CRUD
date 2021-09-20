package wasko.collectionmanager.rpgcollection.validators;

import wasko.collectionmanager.rpgcollection.validators.annotations.ValidPassword;
import wasko.collectionmanager.rpgcollection.dto.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, User> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return false;
    }
}
