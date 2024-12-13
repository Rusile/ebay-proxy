package com.example.ebay_proxy.filter;

import com.example.ebay_proxy.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.soap.client.SoapFaultClientException;


@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value
            = {SoapFaultClientException.class})
    protected ResponseEntity<ErrorResponse> handleConflict(
            RuntimeException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
