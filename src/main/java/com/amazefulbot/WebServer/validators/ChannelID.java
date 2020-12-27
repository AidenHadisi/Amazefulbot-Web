/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChannelIDValidation.class)
@Documented
public @interface ChannelID {
    String message() default  "Incorrect channel ID provided. Please refresh the page and try again.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}