package com.pm.Mapper;

import com.pm.Pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface studentUserMapper extends Mapper<Student> {
    @Select("select * from student where name=#{name}")
    Student selectUserByName(String name);
    @Insert("INSERT into student(name,pwd,radio) VALUES(#{name},#{pwd},2)")
    public void saveUser(String name,String pwd);
}
