package com.pyf.housedbes.service;

import com.pyf.housedbes.dto.PageParam;
import com.pyf.housedbes.entity.House;
import com.pyf.housedbes.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
