package com.pm.management.Pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "feedback")
@Data
public class feedback {

    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;

    private String  back_time;

    private String noclean;

    private String selfcheck;

    private String  plan;

    private String  level;

    private int sid;
}
