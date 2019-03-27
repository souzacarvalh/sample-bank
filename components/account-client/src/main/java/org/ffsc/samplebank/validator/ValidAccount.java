package org.ffsc.samplebank.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Felipe Carvalho on 2019-03-07.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountValidator.class)
@Documented
public @interface ValidAccount {

    String message() default "Invalid Account!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}