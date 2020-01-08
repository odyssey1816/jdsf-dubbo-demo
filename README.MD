## 概述
本demo依赖的dubbo兼容版本是在dubbo官方版本的基础上改造的。支持了consul注册中心，jaeger调用链分析功能。
dubbo配置参考文档：http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-service.html

## 项目说明
  其中module：database-2.6、facade-2.6、consumer-2.6 是dubbo2.6.7兼容版本的demo；
  module：demo-client-2.7、demo-server-2.7、demo-common-2.7  是dubbo2.7.3兼容版本的demo；
  请大家根据自己要使用的dubbo版本查看具体配置
## 一、maven依赖配置
  
 ### dubbo 2.6.7 兼容版本，未上传到maven中央库
       需单独下载 https://jdsf-demo.s3.cn-north-1.jdcloud-oss.com/dubbo-jdsf-2.6.7-SNAPSHOT.jar
       <dependency>
           <groupId>com.alibaba</groupId>
           <artifactId>dubbo-jdsf</artifactId>
           <version>2.6.7-SNAPSHOT</version>
       </dependency>
 ### dubbo 2.7.3 兼容版本 已上传到maven中央库
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
       <dependency>
            <groupId>io.opentracing.contrib</groupId>
            <artifactId>opentracing-spring-jaeger-starter</artifactId>
            <version>2.0.0</version>
        </dependency>
## 二、配置修改项
 ### dubbo 2.7.3 兼容版本配置
  #### 注册中心配置
   xml方式配置方式：
    <!-- 注册中心配置：协议为consul -->  
    <dubbo:registry protocol="consul" address="地址:8500,地址:8500"/>  
    或者  
    <!-- 注册中心配置：协议为consul -->  
    <dubbo:registry address="consul://地址:8500"/>  
    
   springboot配置方式：  
    启动注解：@EnableDubbo(scanBasePackages = "xxx.xxx")  
    配置文件：dubbo.registry.address=consul://127.0.0.1:8500  
    
  #### 调用链配置
    配置文件：  
       dubbo.provider.filter=tracing  
       opentracing.jaeger.HttpSender.url=http://127.0.0.1:14268/api/traces  
    
    configuration初始化：  
       @Bean("tracing")  
       public TracingFilter tracingFilter(Tracer tracer){   
          TracingFilter tracingFilter = new TracingFilter();  
          tracingFilter.setTracer(tracer);  
          return tracingFilter;  
       }  
       
 ### dubbo2.6.7兼容版本配置
    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry protocol="consul" address="地址:8500,地址:8500"/>
    或者
    <!-- 注册中心配置：协议为consul -->
    <dubbo:registry address="consul://地址:8500"/>
     <!-- 调用链配置 -->
    <dubbo:jaegerTrace traceopen="true" type="const" sampling="1" address="127.0.0.1:14268" />

