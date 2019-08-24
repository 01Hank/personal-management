package com.pm.Mapper;

import com.pm.Pojo.MaiaUser;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<MaiaUser> {

    @Insert("INSERT INTO maia_user ( uid,type,firstName,lastName,email,password,birth,cateory,visiable ) VALUES( #{uid},#{type},#{firstName},#{lastName},#{email},#{password},#{birth},#{cateory},#{visiable})")
    public void  register(String uid,int type,String firstName,String lastName,String email,String password,String birth,int cateory,int visiable);
}
