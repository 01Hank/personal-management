package com.pm.Service.Impl;

import com.pm.Mapper.UserMapper;
import com.pm.Pojo.User;
import com.pm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
   @Override
    public List<User> selectUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
