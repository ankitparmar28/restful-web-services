package com.poc.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestap;
    private String message;
    private String details;

    public ExceptionResponse(Date timestap, String message, String details) {
        super();
        this.timestap = timestap;
        this.message = message;
        this.details = details;
    }

    public Date getTimestap() {
        return timestap;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
