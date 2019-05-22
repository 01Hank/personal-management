package com.pm.Mapper;

import com.pm.Pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


public interface teacherUserMapper extends Mapper<Teacher> {
    @Insert("INSERT into teacher(name,pwd,radio) VALUES(#{name},#{pwd},1)")
    public void saveUser(String name,String pwd);
}
