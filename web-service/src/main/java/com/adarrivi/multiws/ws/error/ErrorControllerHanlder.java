package com.adarrivi.multiws.ws.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adarrivi.multiws.ws.response.BasicRs;

@ControllerAdvice
public class ErrorControllerHanlder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorControllerHanlder.class);

    @ExceptionHandler(TypeMismatchException.class)
    public @ResponseBody BasicRs wrongInputNumberFormat(TypeMismatchException ex) {
        LOGGER.debug("Invalid request: " + ex.getMessage(), ex);
        return BasicRs.createErrorResponse("Invalid request:\n" + ex.getCause().getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody BasicRs wrongInputNumberFormatJson(HttpMessageNotReadableException ex) {
        LOGGER.debug("Invalid request: " + ex.getMessage(), ex);
        // we cannot use ex.getCause().getMessage() because the message is quite
        // confusing
        return BasicRs.createErrorResponse("Invalid request:\n Have you introduced an invalid integer value perhaps?");
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody BasicRs unexpectedException(Exception ex) {
        LOGGER.error("Unexpected error found: exception: " + ex.getClass().getName(), ex);
        return BasicRs.createErrorResponse("Sorry, an internal server error has happened");
    }
}
