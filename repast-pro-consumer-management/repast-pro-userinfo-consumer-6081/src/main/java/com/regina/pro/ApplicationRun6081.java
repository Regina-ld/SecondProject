package com.regina.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Regina
 * @data 2019/11/22 10:55
 * @project repast-pro-parent
 * @declaration:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.regina.pro")
public class ApplicationRun6081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class,args);
    }
}
