package com.pm.Service.Impl;
import com.pm.Mapper.studentUserMapper;
import com.pm.Pojo.Student;
import com.pm.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements studentService{
    @Autowired
    private studentUserMapper studentUserMapper;

    @Transactional
    @Override
    public Student selectUserByName(String name) {
        Student student = studentUserMapper.selectUserByName(name);
        return student;
    }

    @Transactional
    @Override
    public int saveUser(Student student) {
        Student student1 = studentUserMapper.selectOne(student);
        if(student1 == null){
            studentUserMapper.saveUser(student.getName(),student.getPwd());
            return 1;
        }
        return 2;
    }
}
