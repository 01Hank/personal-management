package com.pm.management.Pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "student_info")
@Data
public class studentInfo {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int Id;

    private String sname;

    private int sex;

    private int age;

    private Date  bithday;

    private int tid;

    private int sid;


}
