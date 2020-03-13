package com.pyf.house.client;

import com.pyf.house.service.fallback.SmsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SMS-CENTER", fallback = SmsServiceFallback.class)
public interface SmsClient {

    @RequestMapping(value = "/sms-center/sms/send", method = RequestMethod.GET)
    void send(@RequestParam("msg") String msg);
}
