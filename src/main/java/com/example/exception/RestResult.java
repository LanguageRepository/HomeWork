package com.example.exception;

public class RestResult {

    private String status;

    private String message;

    public RestResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestResult(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
