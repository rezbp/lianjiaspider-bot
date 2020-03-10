package com.pyf.house.service;

import com.pyf.house.dto.PageParam;
import com.pyf.house.entity.House;
import com.pyf.house.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;



    public Page getPages(PageParam pageParam) {
        PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize());
        Page<House> page = houseRepository.findAll(pageRequest);
        return  page;

    }
}
