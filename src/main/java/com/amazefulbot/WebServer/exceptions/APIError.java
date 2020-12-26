/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.exceptions;

import org.springframework.http.HttpStatus;


public class APIError {

    private HttpStatus status;
    private String message;
    private String error;


    public APIError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.error = error;
    }
}