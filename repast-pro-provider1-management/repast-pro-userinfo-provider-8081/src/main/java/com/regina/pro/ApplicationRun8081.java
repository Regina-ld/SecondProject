package com.regina.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Regina
 * @data 2019/11/22 15:44
 * @project repast-pro-parent
 * @declaration:
 *      @EnableCircuitBreaker---进入熔断
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan("com.regina.pro.mapper")
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class,args);
    }
}
