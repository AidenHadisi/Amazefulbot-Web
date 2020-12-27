/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserLevelValidation.class)
@Documented
public @interface UserLevels {
    String message() default  "Incorrect user level format.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
