/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CommandRoleValidation implements ConstraintValidator<CommandRole, Integer> {
    private List<Integer> roles = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800);

    @Override
    public boolean isValid(Integer role, ConstraintValidatorContext constraintValidatorContext) {
        return roles.contains(role);
    }
}
