package com.example.demo;/*
 * @description：TODO
 * @author     ：xiejiajian
 * @date       ：2020/7/31 16:31
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}

