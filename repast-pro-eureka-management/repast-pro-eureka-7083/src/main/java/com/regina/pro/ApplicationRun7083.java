package com.regina.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Regina
 * @data 2019/11/22 0:42
 * @project repast-pro-parent
 * @declaration:
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7083 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7083.class,args);
    }
}
