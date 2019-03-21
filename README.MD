##概述
本demo依赖的dubbo兼容版本是在dubbo-2.6.6的基础上改造的。支持了consul注册中心，jaeger调用链分析功能。
dubbo配置参考文档：http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-service.html

##一、maven依赖配置


##二、配置修改项

    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry protocol="consul" address="地址:8500,地址:8500"/>
    或者
    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry address="consul://地址:8500"/>

##三、新增配置项

    <!-- 调用链配置 -->
    <dubbo:jaegerTrace traceopen="true" type="const" sampling="1" address="127.0.0.1:14268" />