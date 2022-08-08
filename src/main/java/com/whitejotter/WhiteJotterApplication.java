package com.whitejotter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.whitejotter.Mapper")
public class WhiteJotterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiteJotterApplication.class, args);
    }

}
