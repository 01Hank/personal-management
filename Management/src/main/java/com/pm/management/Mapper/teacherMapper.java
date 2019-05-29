package com.pm.management.Mapper;

import org.apache.ibatis.annotations.Select;

public interface teacherMapper {
    @Select("select name from teacher where id=#{tid}")
    String  getNameByID(int tid);
}
