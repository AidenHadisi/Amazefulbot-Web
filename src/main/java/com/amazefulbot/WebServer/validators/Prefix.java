/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrefixValidation.class)
@Documented
public @interface Prefix {
    String message() default  "Incorrect prefix provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
