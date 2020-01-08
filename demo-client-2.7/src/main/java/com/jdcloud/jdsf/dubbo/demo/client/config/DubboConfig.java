package com.jdcloud.jdsf.dubbo.demo.client.config;


import io.opentracing.Tracer;
import io.opentracing.dubbo.rpc.filter.TracingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * create by lishijun1 on 2019-08-02 09:51
 * email is lishijun1@jd.com
 */
@Configuration

public class DubboConfig {

    @Bean("tracing")
    public TracingFilter tracingFilter(Tracer tracer){
        TracingFilter tracingFilter = new TracingFilter();
        tracingFilter.setTracer(tracer);
        return tracingFilter;
    }
}
