package com.pyf.sms.service;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.pyf.sms.api.SmsService;
import com.pyf.sms.dto.Body;
import com.pyf.sms.dto.Head;
import com.pyf.sms.dto.SuperFiveDto;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.common.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ADMIN
 */
@Service
public class SmsServiceImpl implements SmsService {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    public static final String PRA_Public_Key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbppJ1W2PAFiXuqWy+WNAKzkhs1TzY1fMEkhHn/UAxqWr5VsOa+6SOZGbeoJKNiumIxzvYLAUHqZJNuAt27CQ/zcEhBSZm/0zkK4ZfMDpPIsE22pnS75k2EVLs2cM+VqF8LTb2kopnMLyY+w/6H/z3yz3Zoan0+70L3JEkGKbH5QIDAQAB";


    @Override
    public boolean sendMail(String msg) {
        logger.info("send msg: {}", msg);
        return true;
    }


    @Override
    public String getRSA() {
        String appId = "wopaitang";
        String appKey = "fml5fd52tso&jsd5#fd";
        String nonceStr = RandomUtil.randomString(9);
        Long timestamp = System.currentTimeMillis();
        String sn = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS") + RandomUtil.randomString(6);
        String sign = SecureUtil.md5().digestHex(appId + nonceStr + sn + timestamp + appKey).toUpperCase();

        RSA rsa = new RSA(null, PRA_Public_Key);
        Head head = new Head(appId, sign, appKey, sn, nonceStr, timestamp);
        Body body = new Body("plus.get.subscriber." +
                "info", "18602032915");
        SuperFiveDto superFiveDto = new SuperFiveDto();
        superFiveDto.setBody(body);
        superFiveDto.setHead(head);
        String superFiveJson = JSONUtil.toJsonStr(superFiveDto);
        byte[] bytes = StrUtil.utf8Bytes(superFiveJson);
        byte[] encrypt = rsa.encrypt(bytes, KeyType.PublicKey);
        String code = Base64.encode(encrypt);


        return code;
    }
}
