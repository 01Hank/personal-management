package com.pm.management;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.pm.management.Mapper")
@RestController
@EnableTransactionManagement
public class ManagementStart {
    public static  void main(String[] args){
        SpringApplication.run(ManagementStart.class,args);
    }
}
