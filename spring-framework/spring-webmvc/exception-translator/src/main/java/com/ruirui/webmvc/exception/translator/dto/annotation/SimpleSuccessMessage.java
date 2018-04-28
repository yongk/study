package com.ruirui.webmvc.exception.translator.dto.annotation;

public class SimpleSuccessMessage extends AbstractResponseMessage implements SuccessMessage {
    public SimpleSuccessMessage() {
        super(200, System.currentTimeMillis());
    }
}
