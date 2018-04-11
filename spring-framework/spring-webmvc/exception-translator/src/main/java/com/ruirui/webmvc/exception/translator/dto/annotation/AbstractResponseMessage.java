package com.ruirui.webmvc.exception.translator.dto.annotation;

public abstract class AbstractResponseMessage implements ResponseMessage {

    private int status;

    private long timestamp;

    public AbstractResponseMessage(int status, long timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
