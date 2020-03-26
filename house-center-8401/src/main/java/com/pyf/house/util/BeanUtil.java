package com.pyf.house.util;

import org.springframework.cglib.beans.BeanMap;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

    /**
     * javabean转map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) instanceof java.sql.Timestamp) {
                    Timestamp timestamp = (java.sql.Timestamp)beanMap.get(key);
                    map.put(key + "", timestamp.toString());
                }else{
                    map.put(key + "", beanMap.get(key));
                }
            }
        }
        return map;
    }

}
