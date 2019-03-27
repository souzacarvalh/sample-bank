package org.ffsc.samplebank;


import org.hibernate.validator.HibernateValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by Felipe Carvalho on 2019-03-09.
 */

@Configuration
public class AccountClientConfiguration {

    @Bean
    public Validator validator(ApplicationContext applicationContext) {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorFactory(new SpringConstraintValidatorFactory(applicationContext.getAutowireCapableBeanFactory()))
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }
}