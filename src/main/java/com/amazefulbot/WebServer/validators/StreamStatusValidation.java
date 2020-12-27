/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StreamStatusValidation implements ConstraintValidator<StreamStatus, Integer> {
    private List<Integer> streams = Arrays.asList(100, 200, 300);

    @Override
    public boolean isValid(Integer status, ConstraintValidatorContext constraintValidatorContext) {
        return streams.contains(status);
    }
}
