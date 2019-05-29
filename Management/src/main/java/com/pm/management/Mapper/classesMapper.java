package com.pm.management.Mapper;

import com.pm.management.Pojo.dao.Cla;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface classesMapper extends Mapper<Cla> {
    @Select("select name from classes where tid=#{tid}")
    String getClassByTid(int tid);
}
