package com.karuturirs.gcp.webapp.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "errors")
public class ApplicationErrorMessage {

    @JsonProperty(value = "error")
    List <Error> errorList;

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List <Error> errorList) {
        this.errorList = errorList;
    }

    public ApplicationErrorMessage(List <Error> errorList) {
        this.errorList = errorList;
    }

}