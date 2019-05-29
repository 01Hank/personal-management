package com.pm.management.Pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int Id;

    private String name;

    private String pwd;

    //标识权限
    private String radio;

}
