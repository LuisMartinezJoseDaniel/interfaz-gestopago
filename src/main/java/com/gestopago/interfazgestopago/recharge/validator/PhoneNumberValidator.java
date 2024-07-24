package com.gestopago.interfazgestopago.recharge.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    
    private static final String PHONE_NUMBER_PATTERN = "^\\+?[0-9. ()-]{7,25}$";
    
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }
    
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            return false;
        }
        return Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber);
    }
}
