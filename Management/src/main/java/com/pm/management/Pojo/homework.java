package com.pm.management.Pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "homework")
@Data
public class homework{
    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;

    private String content;

    private int tid;

    private Date starttime;

    private String type;
}
