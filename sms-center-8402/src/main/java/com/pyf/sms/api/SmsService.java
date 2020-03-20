package com.pyf.sms.api;

public interface SmsService {

    boolean sendMail(String msg);

    String getRSA();

    String getToken();


    String checkToken(String token);
}
