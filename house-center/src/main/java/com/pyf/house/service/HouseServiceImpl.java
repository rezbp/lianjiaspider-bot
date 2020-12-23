package com.pyf.house.service;

import com.pyf.common.AesUtil;
import com.pyf.house.api.HouseService;
import com.pyf.house.client.SmsClient;
import com.pyf.house.dto.PageParam;
import com.pyf.house.entity.House;
import com.pyf.house.repository.HouseRepository;
import com.pyf.sms.api.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {


    private final static Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);

    @Autowired
    private HouseRepository houseRepository;


    @Autowired
    private SmsClient smsClient;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    EsServiceImpl esService;


    @Override
    public Page getPages(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize());
        Page<House> page = houseRepository.findAll(pageRequest);
        smsClient.send("6666666");
        return page;

    }

    @Override
    public Object setKv(String name, Double price) {
        redisTemplate.opsForValue().set(name, price.toString(), 600);

        return null;
    }

    @Override
    public Object getAes(String phone) throws Exception {
        return AesUtil.encry(phone, "SFX75R7D7EECB741KGJVD66A7HJVD54Z");
    }

    @Override
    public Object indexHouseToEs(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize());
        Page<House> page = houseRepository.findAll(pageRequest);
        List<House> houseList = page.getContent();
        houseList.stream().forEach(t -> {
            try {
                boolean exist = esService.isExist("house-center", "house", t.getId().toString());
                if (!exist) {
                    esService.create("house-center", "house", t);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        });
        return true;
    }

    @Override
    public Object getHouseEsIndex(String index, String type, String id) throws IOException {
        boolean exist = esService.isExist(index, type, id);
        return exist;
    }

    @Override
    public Object getHouseLimit() {
        for (long i = 0; i < 30000; i = i + 100) {
            List<House> list = houseRepository.findList(100L, i);
            logger.info("getHouseLimit:i:{}", i);
            list.parallelStream().forEach(t -> {

            });
        }

        return true;
    }

}
