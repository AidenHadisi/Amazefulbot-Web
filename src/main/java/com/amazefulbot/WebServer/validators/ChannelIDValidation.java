/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.validators;

import com.amazefulbot.WebServer.config.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChannelIDValidation implements ConstraintValidator<ChannelID, Integer> {


    @Override
    public boolean isValid(Integer channelID, ConstraintValidatorContext constraintValidatorContext) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return channelID == principal.getCurrent_channel().getId();
    }
}
