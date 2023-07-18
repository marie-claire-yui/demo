package com.autourducode.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
public class SpringSecurityBasicAuthApplication {
    
    AuthenticationFilter

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBasicAuthApplication.class, args);
    }

}
