package com.karuturirs.gcp.webapp.exception;

public class ApplicationException extends RuntimeException {

    private String errorMessage;

    private String errorCode;

    private String statusCode;

    public ApplicationException() {
    }

    public ApplicationException(String errorMessage, String errorCode, String statusCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
