package com.pm.management;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@MapperScan("com.pm.management.Mapper")
@RestController
@EnableTransactionManagement
public class ManagementStart {
    public static  void main(String[] args){
        SpringApplication.run(ManagementStart.class,args);
    }
}
