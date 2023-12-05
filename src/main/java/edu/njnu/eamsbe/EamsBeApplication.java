package edu.njnu.eamsbe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("edu.njnu.eamsbe.service")
@ComponentScan("edu.njnu.eamsbe.controller")
@MapperScan("edu.njnu.eamsbe.mapper")
@ComponentScan("edu.njnu.eamsbe.cors")
public class EamsBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamsBeApplication.class, args);
    }


}


