package com.ruirui.webmvc.exception.translator.dto.annotation;

public class ErrorMessage extends AbstractResponseMessage {

    private String error;

    private String message;

    private String path; /* request path */


    public ErrorMessage(String error, String message, String path) {
        this(500, error, message, path);
    }

    public ErrorMessage(int status, String error, String message, String path) {
        super(status, System.currentTimeMillis());
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
