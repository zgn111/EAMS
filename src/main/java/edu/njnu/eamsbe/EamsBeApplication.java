package edu.njnu.eamsbe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.njnu.eamsbe.service")
@ComponentScan("edu.njnu.eamsbe.controller")
@MapperScan("edu.njnu.eamsbe.mapper")
public class EamsBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamsBeApplication.class, args);
    }

}
