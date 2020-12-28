/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommandAliasesValidation.class)
@Documented
public @interface CommandAliases {
    String message() default  "Command alias must be between 1 and 50 characters long and cannot contain whitespaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
