package com.pm.Service.Impl;

import com.pm.Mapper.UserMapper;
import com.pm.Pojo.MaiaUser;
import com.pm.Service.UserService;
import com.pm.Utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper  userMapper;

    @Override
    public void register(MaiaUser user) {
        //生成UUID
        String uuid = new UUIDs().getUUID();
        user.setUid(uuid);
        user.setBirth("1");
        user.setCateory(0);
        user.setVisiable(0);

        userMapper.register(uuid,user.getType(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getBirth(),user.getCateory(),user.getVisiable());

    }
}
