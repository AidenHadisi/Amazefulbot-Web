/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.config;


import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface PublicAPI {
    @AliasFor(
            annotation = RestController.class
    )
    String value() default "";
}


