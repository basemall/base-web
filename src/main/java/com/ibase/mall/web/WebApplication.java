package com.ibase.mall.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by huixiong on 2018/2/11.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages={"com.ibase.mall.web"})
public class WebApplication {


    public static void main(String[] args){
        new SpringApplicationBuilder(WebApplication.class).web(true).run(args);
    }


}
