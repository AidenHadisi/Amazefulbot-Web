/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CommandAliasesValidation implements ConstraintValidator<CommandAliases, List<String>> {

    @Override
    public boolean isValid(List<String> strings, ConstraintValidatorContext constraintValidatorContext) {

        return strings.stream().allMatch(str -> str.length() > 0 && str.length() < 51 && str.matches("^[^\\s]+$"));

    }
}
