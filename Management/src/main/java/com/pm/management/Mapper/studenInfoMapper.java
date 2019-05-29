package com.pm.management.Mapper;

import com.pm.management.Pojo.dao.option;
import com.pm.management.Pojo.studentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;


public interface studenInfoMapper extends Mapper<studentInfo> {
    @Select("select * from student_info where sid=#{sid}")
    studentInfo selectBySid(int sid);

    @Select("select id,name from teacher")
    List<option> selectTeacherList();


    @Update("update student_info SET age=#{age},sname=#{sname},bithday=#{bithday},tid=#{tid},sex=#{sex} WHERE sid = #{sid}")
    void  updateStudentInfo(int sid, String sname, int age, String bithday, int tid,int sex);

    @Select("select tid from student_info where sid=#{sid}")
    int getClassByTid(int sid);

    @Insert("INSERT INTO student_info (sid)  VALUES  (#{sid})")
    void insertstudent(int sid);
}
