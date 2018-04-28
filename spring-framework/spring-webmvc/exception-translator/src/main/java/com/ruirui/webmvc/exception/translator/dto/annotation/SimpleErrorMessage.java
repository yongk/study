package com.ruirui.webmvc.exception.translator.dto.annotation;

public class SimpleErrorMessage extends AbstractResponseMessage implements ErrorMessage {

    private String error;

    private String message;

    private String path; /* request path */


    public SimpleErrorMessage(String error, String message, String path) {
        this(500, error, message, path);
    }

    public SimpleErrorMessage(int status, String error, String message, String path) {
        super(status, System.currentTimeMillis());
        this.error = error;
        this.message = message;
        this.path = path;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getPath() {
        return path;
    }
}
