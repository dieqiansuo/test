package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/8/14.
 */
public class RedisController {
    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void demoTest(){
        redisService.set("1","value22222");
    }
}
