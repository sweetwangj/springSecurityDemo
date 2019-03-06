package com.operation.qkwall;

import com.operation.qkwall.security.AccessDeniedServletHandler;
import com.operation.qkwall.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.operation.qkwall.mapper")
public class OperationApplication{
    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class, args);
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }






}
