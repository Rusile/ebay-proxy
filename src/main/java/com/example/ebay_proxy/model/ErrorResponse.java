package com.example.ebay_proxy.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("cause")
    private final String cause;

    @JsonCreator
    public ErrorResponse(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }
}
