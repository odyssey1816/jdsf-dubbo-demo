package com.jdcloud.jdsf.dubbo.demo.server.service.impl;

import com.yy.aurogon.gumiho.verify.api.TestService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Date;

/**
 * create by lishijun1 on 2019-08-01 21:30
 * email is lishijun1@jd.com
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String hello(String input) {
        return " haha====cccccc===="+input;
    }

//    @Override
//    public String echo(String value) {
//        return "Hello, "+ value;
//    }
//
//    @Override
//    public String echo(String value, long time) {
//        return "Hello, "+ value+" "+ new Date(time);
//    }
}
