package com.ruirui.webmvc.exception.translator.dto.annotation;

public interface ErrorMessage extends ResponseMessage {
    String getError();

    String getMessage();

    String getPath();
}
