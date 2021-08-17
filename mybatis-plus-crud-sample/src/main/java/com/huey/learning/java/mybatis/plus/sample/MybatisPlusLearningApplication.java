package com.huey.learning.java.mybatis.plus.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huey.learning.java.mybatis.plus.sample.mapper")
public class MybatisPlusLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusLearningApplication.class, args);
    }

}
