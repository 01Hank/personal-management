package com.pm.Pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long Id;

    private String name;

}
