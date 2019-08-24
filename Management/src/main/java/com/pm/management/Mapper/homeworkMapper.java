package com.pm.management.Mapper;

import com.pm.management.Pojo.homework;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface homeworkMapper extends Mapper<homework> {
    @Select("SELECT * FROM homework where tid=#{tid}")
    List<homework> getByTid(int tid);
}
