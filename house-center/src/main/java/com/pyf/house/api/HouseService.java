package com.pyf.house.api;

import com.pyf.house.dto.PageParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface HouseService {

    Page getPages(@RequestParam("pageParam") PageParam pageParam);

    Object setKv(String name, Double price);

    Object getAes(String phone) throws Exception;

    Object indexHouseToEs(PageParam pageParam);

    Object getHouseEsIndex(String index, String type, String id) throws IOException;

    Object getHouseLimit();
}
