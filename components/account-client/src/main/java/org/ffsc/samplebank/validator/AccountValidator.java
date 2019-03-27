package org.ffsc.samplebank.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by Felipe Carvalho on 2019-03-07.
 */
public class AccountValidator implements ConstraintValidator<ValidAccount, String> {

    private static final Pattern ACCOUNT_PATTERN = Pattern.compile("[0-9]{4}-[0-9]{1}$");

    @Override
    public void initialize(ValidAccount constraintAnnotation) {

    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
        try {
            return fieldValue != null && ACCOUNT_PATTERN.matcher(fieldValue).matches();
        } catch (IllegalStateException e) {
            return false;
        }
    }
}