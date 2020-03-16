package com.pyf.house.controller;

import com.pyf.house.annotation.Token;
import com.pyf.house.api.HouseService;
import com.pyf.house.dto.PageParam;
import com.pyf.house.service.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/getPages", method = RequestMethod.GET)
    @ResponseBody
    @Token
    public Page getHousePage(@RequestBody PageParam pageParam) {
        return houseService.getPages(pageParam);
    }
}
