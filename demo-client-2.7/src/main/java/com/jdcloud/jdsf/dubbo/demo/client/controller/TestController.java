package com.jdcloud.jdsf.dubbo.demo.client.controller;


import com.jdcloud.jdsf.dubbo.demo.server.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * create by lishijun1 on 2019-08-02 11:55
 * email is lishijun1@jd.com
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Reference(check = false,async = false)
    TestService testService;

    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){
        return testService.echo(name);
    }


    @RequestMapping(value = "/sayhello2",method = RequestMethod.GET)
    public String sayHello2(@RequestParam String name){
        return testService.echo(name,new Date().getTime());
    }
}
