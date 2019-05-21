package com.pm.Service.Impl;

import com.pm.Mapper.teacherUserMapper;
import com.pm.Pojo.teacherUser;
import com.pm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TeacherUserServiceImpl implements UserService {
    @Autowired
    private teacherUserMapper teacherUserMapper;

    @Transactional
    @Override
    public teacherUser selectUserByName(String name) {
        teacherUser t = new teacherUser();
        t.setName(name);
        teacherUser teacherUser = teacherUserMapper.selectOne(t);
        return teacherUser;
    }
}
