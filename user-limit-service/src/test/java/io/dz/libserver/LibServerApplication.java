package io.dz.libserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration
public class LibServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibServerApplication.class, args);
    }

}
