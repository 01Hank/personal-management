package com.pm.management.Service.Impl;

import com.pm.management.Mapper.classesMapper;
import com.pm.management.Mapper.studenInfoMapper;
import com.pm.management.Mapper.studentMapper;
import com.pm.management.Mapper.teacherMapper;
import com.pm.management.Pojo.dao.Cla;
import com.pm.management.Pojo.dao.option;
import com.pm.management.Pojo.studentInfo;
import com.pm.management.Service.studentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class studentInfoImpl implements studentInfoService {
    @Autowired
    private studenInfoMapper sfMapper;

    @Autowired
    private studentMapper stMapper;

    @Autowired
    private classesMapper claMapper;

    @Autowired
    private teacherMapper  teaMapper;

    @Transactional
    @Override
    public studentInfo selectById(int sid) {
//        studentInfo s1 = new studentInfo();
//        s1.setSid(sid);
        studentInfo stu = sfMapper.selectBySid(sid);
       // studentInfo studentInfo = sfMapper.selectOne(s1);

        if(StringUtils.isEmpty(stu) || stu.getId()==0){
            sfMapper.insertstudent(sid);
            studentInfo studentInfo1 = new studentInfo();
            studentInfo1.setSid(sid);
            return studentInfo1;
        }
        return stu;
    }
    @Transactional
    @Override
    public List<option> getTeacherList() {
        List<option> options = sfMapper.selectTeacherList();


        return options;
    }
    @Transactional
    @Override
    public void updateStudentInfo(int sid, String sname, int age, String bithday, int tid,int sex) {

        sfMapper.updateStudentInfo(sid,sname,age,bithday,tid,sex);
        stMapper.updateStudent(sid,tid);
    }

    //根据sid查找老师和课程
    @Transactional
    @Override
    public Cla getClaByTid(int i) {
        int tid = sfMapper.getClassByTid(i);
        String Tname = teaMapper.getNameByID(tid);
        String Cname = claMapper.getClassByTid(tid);
        Cla cla = new Cla();
        cla.setCname(Cname);
        cla.setTname(Tname);
        return cla;
    }
}
