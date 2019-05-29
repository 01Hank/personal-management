package com.pm.management.Mapper;

import com.pm.management.Pojo.student;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface studentMapper extends Mapper<student> {

    @Update("update student SET tid=#{tid} WHERE id = #{sid}")
    void  updateStudent(int sid,int tid);
}
