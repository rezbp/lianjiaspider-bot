package com.pyf.sms.dto;

import lombok.Data;

@Data
public class Body {

    private String method;

    private String mobile;

    public Body(String method, String mobile) {
        this.method = method;
        this.mobile = mobile;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
