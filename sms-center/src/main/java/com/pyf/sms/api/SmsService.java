package com.pyf.sms.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sms-center")
public interface SmsService {


    /**
     * sendMsg
     * @param msg
     */
    @GetMapping("/send")
    void sendMail(@RequestParam("msg") String msg);
}
