package com.jdcloud.jdsf.dubbo.demo.server.service;

/**
 * create by lishijun1 on 2019-08-01 21:30
 * email is lishijun1@jd.com
 */
public interface TestService {


    String echo(String value);

    String echo(String value, long time);
}
