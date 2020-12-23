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


    @RequestMapping(value = "/getRSA", method = RequestMethod.GET)
    public String getRSA() {
        return smsService.getRSA();
    }

    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public String getToken() {
        return smsService.getToken();
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    public String checkToken(@RequestParam("token") String token) {
        return smsService.checkToken(token);
    }
}
