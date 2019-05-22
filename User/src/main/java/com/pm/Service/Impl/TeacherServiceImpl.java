package com.pm.Service.Impl;

import com.pm.Mapper.teacherUserMapper;
import com.pm.Pojo.Teacher;
import com.pm.Service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class TeacherServiceImpl implements teacherService {
    @Autowired
    private teacherUserMapper teacherUserMapper;

    @Transactional
    @Override
    public Teacher selectUserByName(String name) {
        Teacher t = new Teacher();
        t.setName(name);
        Teacher teacherUser = teacherUserMapper.selectOne(t);
        return teacherUser;
    }

    @Override
    public  int saveUser(Teacher t) {
        Teacher teacher = teacherUserMapper.selectOne(t);
        if(teacher == null) {
            teacherUserMapper.saveUser(t.getName(),t.getPwd());
            return 1;
        }
            return 2;

    }
}
