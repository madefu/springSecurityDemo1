package com.madefu.spd1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemo1Application {

    /**
     * SpringSecurity 本质是一个过滤器链
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemo1Application.class, args);
    }

}
