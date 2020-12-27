/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StreamStatusValidation.class)
@Documented
public @interface StreamStatus {
    String message() default  "Incorrect stream status provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
