package com.platform.usermanager.validation.validator;

import com.platform.usermanager.RegexPatterns;
import com.platform.usermanager.validation.annotation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password != null && password.matches(RegexPatterns.PASSWORD_PATTERN);
    }
}
