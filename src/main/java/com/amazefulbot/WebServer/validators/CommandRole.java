/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommandRoleValidation.class)
@Documented
public @interface CommandRole {
    String message() default "Invalid command level provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
