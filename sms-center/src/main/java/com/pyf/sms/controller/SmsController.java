package com.pyf.sms.controller;

import com.pyf.sms.api.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;


    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send(@RequestParam("msg") String msg) {
        smsService.sendMail(msg);
    }
}
