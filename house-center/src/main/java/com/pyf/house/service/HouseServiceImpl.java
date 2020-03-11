package com.pyf.house.service;

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
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {


    private final static Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);

    @Autowired
    private HouseRepository houseRepository;


    @Autowired
    private SmsClient smsClient;



    @Override
    public Page getPages(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize());
        Page<House> page = houseRepository.findAll(pageRequest);
        smsClient.send("6666666");

        return  page;

    }
}
