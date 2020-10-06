package com.karuturirs.gcp.webapp.exception;

public enum ErrorCodes {

    INTERNAL_ERROR("1000","Internal error processing the Request");


    private String errorCode;
    private String errorMessage;

    ErrorCodes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
