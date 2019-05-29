package com.pm.management.Mapper;

import com.pm.management.Pojo.feedback;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface feedbackMapper extends Mapper<feedback> {

    @Select("select * from feedback where sid=#{sid}")
    List<feedback>  getAllFeedbackBySid(int sid);

    @Delete("DELETE FROM feedback WHERE id=#{id}")
    void deletById(int id);

    @Insert("INSERT INTO feedback ( back_time,noclean,selfcheck,plan,level,sid) VALUES( #{back_time},#{noclean},#{selfcheck},#{plan},#{level},#{sid})")
    void insertFeedback(String back_time,String noclean,String selfcheck,String plan,String level,int sid);

 }
