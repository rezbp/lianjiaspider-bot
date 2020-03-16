package com.pyf.house.api;

import com.pyf.house.dto.PageParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HouseService {

    Page getPages(@RequestParam("pageParam") PageParam pageParam);
}
