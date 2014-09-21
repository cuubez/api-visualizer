package com.cuubez.visualizer.domain.configuration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class HttpCode {

    private int code;
    private String reason;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
