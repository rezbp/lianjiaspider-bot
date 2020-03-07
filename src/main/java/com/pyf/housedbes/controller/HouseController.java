package com.pyf.housedbes.controller;

import com.pyf.housedbes.dto.PageParam;
import com.pyf.housedbes.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
