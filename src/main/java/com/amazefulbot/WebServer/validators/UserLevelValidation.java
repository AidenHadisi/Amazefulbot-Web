/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserLevelValidation implements ConstraintValidator<UserLevels, HashMap<String, Integer>> {
    private List<Integer> roles = Arrays.asList(400, 500, 700);

    @Override
    public boolean isValid(HashMap<String, Integer> map, ConstraintValidatorContext constraintValidatorContext) {
        return map.values().stream().allMatch( e -> roles.contains(e) );
    }
}
