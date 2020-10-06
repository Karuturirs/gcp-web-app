package com.karuturirs.gcp.webapp.exception;

public class Error {

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Error(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
