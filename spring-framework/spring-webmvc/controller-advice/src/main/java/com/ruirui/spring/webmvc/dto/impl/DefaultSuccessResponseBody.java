package com.ruirui.spring.webmvc.dto.impl;

import com.ruirui.spring.webmvc.dto.SuccessResponseBody;

public class DefaultSuccessResponseBody implements SuccessResponseBody {

    private static final String SUCCESS_CODE = "200";

    private String code;

    private Object data;

    public DefaultSuccessResponseBody(Object data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "code: " + getCode() + ", data: " + getData();
    }
}
