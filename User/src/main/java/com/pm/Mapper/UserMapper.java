package com.pm.Mapper;

import com.pm.Pojo.MaiaUser;
import com.pm.Pojo.db.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import javax.xml.crypto.Data;
import java.util.Date;

public interface UserMapper extends Mapper<MaiaUser> {
    //查询token拦截
    @Select("select *  from maia_token where token=#{token}")
    public Token selectToken(String token);

    //更新token
    @Update("update maia_token set token=#{token}  where user_uuid=#{uuid} ")
    public  void updateToken(String uuid,String token);

    //查询token
    @Select("select *  from maia_token where user_uuid=#{uuid}")
    public Token getToken(String uuid);

    //存token
    @Insert("insert into maia_token (user_uuid,token,time)  values(#{uuid},#{token},#{time})")
    public  void insertToken(String uuid, String token, Date  time);
    //登录
    @Select("select * from maia_user where email=#{email}")
    public MaiaUser selectByEmail(String email);

    //注册
    @Insert("INSERT INTO maia_user ( uid,type,firstName,lastName,email,password,birth,cateory,visiable ) VALUES( #{uid},#{type},#{firstName},#{lastName},#{email},#{password},#{birth},#{cateory},#{visiable})")
    public void  register(String uid,int type,String firstName,String lastName,String email,String password,String birth,int cateory,int visiable);
}
