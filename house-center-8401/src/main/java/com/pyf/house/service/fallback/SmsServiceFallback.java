package com.pyf.house.service.fallback;

import com.pyf.house.client.SmsClient;
import com.pyf.house.service.HouseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Sms服务熔断类
 *
 * @author ADMIN
 */
@Service
public class SmsServiceFallback implements SmsClient {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceFallback.class);

    @Override
    public void send(String msg) {
        logger.info("SmsServiceFallback:send: hystrix!!!fallback");
    }
}
