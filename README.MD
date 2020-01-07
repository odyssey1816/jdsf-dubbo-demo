## 概述
本demo依赖的dubbo兼容版本是在dubbo的基础上改造的。支持了consul注册中心，jaeger调用链分析功能。
dubbo配置参考文档：http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-service.html

## 一、maven依赖配置
  ### dubbo 2.7.3 兼容版本 推荐使用
        <!-- 注册中心配置依赖 -->
        <dependency>
           <groupId>com.jdcloud.jdsf</groupId>
           <artifactId>dubbo-registry-consul</artifactId>
           <version>1.0.0</version>
       </dependency>
       <!-- 调用链配置依赖 -->
       <dependency>
           <groupId>com.jdcloud.jdsf</groupId>
           <artifactId>dubbo-opentracing</artifactId>
           <version>1.0.0</version>
       </dependency>
 ### dubbo 2.6.7 兼容版本，已废弃
       <dependency>
           <groupId>com.alibaba</groupId>
           <artifactId>dubbo-jdsf</artifactId>
           <version>2.6.7-SNAPSHOT</version>
       </dependency>
## 二、配置修改项

    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry protocol="consul" address="地址:8500,地址:8500"/>
    或者
    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry address="consul://地址:8500"/>

## 三、新增配置项

    <!-- 调用链配置 -->
    <dubbo:jaegerTrace traceopen="true" type="const" sampling="1" address="127.0.0.1:14268" />
