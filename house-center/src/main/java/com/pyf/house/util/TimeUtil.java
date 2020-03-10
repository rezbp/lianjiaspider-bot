package com.pyf.house.util;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ADMIN
 */
@Component
public class TimeUtil {

    private final static Logger logger = LoggerFactory.getLogger("TimeUtil");


    public static Long getCurrentTime() {
        Long time = System.currentTimeMillis();
        logger.info("System.currentTimeSecond:{}, timeStr: {}", time, DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return time;
    }

}
