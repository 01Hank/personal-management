package com.pm.Pojo.db;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "maia_token")
public class Token {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;
    @Column(name = "user_uuid")
    private  String user_uuid;
    private String token;
    private String time;
}
