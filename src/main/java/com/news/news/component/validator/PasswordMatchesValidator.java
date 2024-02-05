package com.news.news.component.validator;

import com.news.news.common.annotation.PasswordMatches;
import com.news.news.dto.request.AccountRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        AccountRequest accountInput = (AccountRequest) o;
        return accountInput.getPassword().equals(accountInput.getMatchingPassword());
    }
}