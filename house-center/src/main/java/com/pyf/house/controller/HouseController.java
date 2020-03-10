package com.pyf.house.controller;

import com.pyf.house.api.HouseService;
import com.pyf.house.dto.PageParam;
import com.pyf.house.service.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/getPages", method = RequestMethod.GET)
    @ResponseBody
    public Page getHousePage(@RequestBody PageParam pageParam) {
        return houseService.getPages(pageParam);
    }
}
