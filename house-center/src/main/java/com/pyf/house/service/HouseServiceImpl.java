package com.pyf.house.service;

import com.pyf.house.api.HouseService;
import com.pyf.house.dto.PageParam;
import com.pyf.house.entity.House;
import com.pyf.house.repository.HouseRepository;
import com.pyf.sms.api.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("HouseService")
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private SmsService smsService;


    @Override
    public Page getPages(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize());
        Page<House> page = houseRepository.findAll(pageRequest);
        smsService.sendMail("6666");
        return  page;

    }
}
