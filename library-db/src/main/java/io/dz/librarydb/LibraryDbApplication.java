package io.dz.library_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude = {ErrorMvcAutoConfiguration.class})*/
@EnableDiscoveryClient
@ComponentScan("io.dz.librarydb")
@EnableCaching
public class LibraryDbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LibraryDbApplication.class, args);
    }

}
