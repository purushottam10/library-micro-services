package io.dz.userlimitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableEurekaClient
public class UserLimitServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserLimitServiceApplication.class, args);
    }

}
