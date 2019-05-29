package com.pm.management.Service;

import com.pm.management.Pojo.dao.Cla;
import com.pm.management.Pojo.dao.option;
import com.pm.management.Pojo.studentInfo;

import java.util.List;


public interface studentInfoService {

    studentInfo selectById(int id);
    List<option> getTeacherList();

    void updateStudentInfo(int sid, String sname, int age, String bithday, int tid,int sex);

    Cla getClaByTid(int i);
}
