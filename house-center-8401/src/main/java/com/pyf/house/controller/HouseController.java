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


    @RequestMapping(value = "/setKv", method = RequestMethod.GET)
    @ResponseBody
    public Object setKv(@RequestParam String name, @RequestParam Double price) {
        return houseService.setKv(name, price);
    }

    @RequestMapping(value = "/indexHouseToEs", method = RequestMethod.GET)
    @ResponseBody
    public Object indexHouseToEs(@RequestBody PageParam pageParam) throws Exception {
        return houseService.indexHouseToEs(pageParam);
    }


    @RequestMapping(value = "/getHouseEsIndex", method = RequestMethod.GET)
    @ResponseBody
    public Object getHouseEsIndex(@RequestParam String index, @RequestParam String type, @RequestParam String id) throws Exception {
        return houseService.getHouseEsIndex(index, type, id);
    }

    @RequestMapping(value = "/getHouseLimit", method = RequestMethod.GET)
    @ResponseBody
    public Object getHouseLimit() throws Exception {
        return houseService.getHouseLimit();
    }
}
