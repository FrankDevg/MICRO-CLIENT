package com.developer.minegociomanagement.dto.response;

import java.io.Serializable;

public class ResultClientResponse implements Serializable {

    private Integer code;

    private String message;
    private ClientResponse result;



    public ResultClientResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClientResponse getResult() {
        return result;
    }

    public void setResult(ClientResponse result) {
        this.result = result;
    }
}
