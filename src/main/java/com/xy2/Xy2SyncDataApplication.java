package com.xy2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@SpringBootApplication
@EnableTransactionManagement
public class Xy2SyncDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Xy2SyncDataApplication.class, args);
    }

}
