package com.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.pm.Mapper")
@RestController
@EnableTransactionManagement
public class UserStart {
    public static void main(String[] args){
        SpringApplication.run(UserStart.class,args);
    }
}
