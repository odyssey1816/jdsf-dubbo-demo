/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jdcloud.jdsf.consumer;


import com.jdcloud.jdsf.facade.bean.ValidationParameter;
import com.jdcloud.jdsf.facade.service.ValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * ValidationConsumer
 */
public class ValidationConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("validation-consumer.xml");
        context.start();

        ValidationService validationService = (ValidationService) context.getBean("validationService");

        while (true) {
            // Save OK
            ValidationParameter parameter = new ValidationParameter();
            parameter.setName("liangfei");
            parameter.setEmail("liangfei@liang.fei");
            parameter.setAge(50);
            parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
            parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
            validationService.save(parameter);
            System.out.println("Validation Save OK");

        }
    }

}
