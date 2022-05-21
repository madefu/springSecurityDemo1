package com.madefu.spd1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.madefu.spd1.mybatis.generator.mapper.test_v0")
public class SpringSecurityDemo1Application {

    /**
     * SpringSecurity 本质是一个过滤器链
     *
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemo1Application.class, args);
    }

}
