package com.pyf.sms.service;

import com.pyf.sms.api.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author ADMIN
 */
@Service("SmsService")
public class SmsServiceImpl implements SmsService {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Override
    public void sendMail(String msg) {
        logger.info("send msg: {}", msg);
    }
}
