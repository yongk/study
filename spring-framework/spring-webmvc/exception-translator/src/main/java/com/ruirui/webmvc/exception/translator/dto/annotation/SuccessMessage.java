package com.ruirui.webmvc.exception.translator.dto.annotation;

public class SuccessMessage extends AbstractResponseMessage {
    public SuccessMessage() {
        super(200, System.currentTimeMillis());
    }
}
