package com.pm.Service.Impl;

import com.pm.Mapper.UserMapper;
import com.pm.Pojo.MaiaUser;
import com.pm.Pojo.db.Login;
import com.pm.Pojo.db.Token;
import com.pm.Service.UserService;
import com.pm.UserStart;
import com.pm.Utils.Tokens;
import com.pm.Utils.UUIDs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;



@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserStart.class);


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
        //判断存不存在用户
        try{
            MaiaUser maiaUser = userMapper.selectByEmail(user.getEmail());
            if(maiaUser==null){
                userMapper.register(uuid,user.getType(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getBirth(),user.getCateory(),user.getVisiable());
            }
        }catch (Exception e){
            logger.error("注册错误");
        }


    }

    @Override
    public String login(Login logins) throws Exception {
        MaiaUser user = userMapper.selectByEmail(logins.getEmail_address());
        if(user.getPassword().equals(logins.getPassword())){
            //登陆成功
            try{
                Token tokens = userMapper.getToken(user.getUid());//获取token
                //token被删除
                if(tokens.getToken()==null || "".equals(tokens.getToken())){
                    String token = new Tokens().getToken(user.getEmail());
                    userMapper.updateToken(user.getUid(),token);
                    return token;
                }

                return tokens.getToken();
            }catch (Exception e){
                //没有token
                String token = new Tokens().getToken(user.getEmail());
                userMapper.insertToken(user.getUid(),token,new Date());
                return token;
            }
        }else {
            //登录失败
            return "0";
        }
    }
}
