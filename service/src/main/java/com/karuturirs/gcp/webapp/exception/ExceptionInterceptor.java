package com.karuturirs.gcp.webapp.exception;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(ApplicationException.class)
    public final ResponseEntity<ApplicationErrorMessage> handleAllExceptions(ApplicationException ex) {
        Error error = new Error(ex.getErrorMessage(),ex.getErrorCode());
        ApplicationErrorMessage appErrorMessageSchema =
                new ApplicationErrorMessage(Arrays.asList(error));
        return new ResponseEntity<>(appErrorMessageSchema, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<Exception> handleAllExceptions(Throwable ex) {

        Error error = new Error(ExceptionUtils.getStackTrace(ex),ErrorCodes.INTERNAL_ERROR.getErrorCode());
        ApplicationErrorMessage appErrorMessageSchema =
                new ApplicationErrorMessage(Arrays.asList(error));
        return new ResponseEntity(appErrorMessageSchema, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
