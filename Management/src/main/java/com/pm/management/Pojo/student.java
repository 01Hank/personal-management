package com.pm.management.Pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "student")
@Data
public class student {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int Id;

    private String name;

    private String pwd;

    private int tid;

    //标识权限
    private String radio;
}
