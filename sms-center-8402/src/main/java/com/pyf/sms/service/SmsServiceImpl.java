package com.pyf.sms.service;

import com.pyf.sms.api.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ADMIN
 */
@Service
public class SmsServiceImpl implements SmsService {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);



    @Override
    public boolean sendMail(String msg) {
        logger.info("send msg: {}", msg);
        return true;
    }
}
