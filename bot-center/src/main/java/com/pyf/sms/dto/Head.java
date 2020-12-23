package com.pyf.sms.dto;

import lombok.Data;

@Data
public class Head {

    private String appid;

    private String sign;

    private String appKey;

    private String sn;

    private String noncestr;

    private Long timestamp;


    public Head(String appid, String sign, String appKey, String sn, String noncestr, Long timestamp) {
        this.appid = appid;
        this.sign = sign;
        this.appKey = appKey;
        this.sn = sn;
        this.noncestr = noncestr;
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
