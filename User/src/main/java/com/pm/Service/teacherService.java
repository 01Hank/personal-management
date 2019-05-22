package com.pm.Service;


import com.pm.Pojo.Teacher;

public interface teacherService {

    <T> T selectUserByName(String name);

      int  saveUser(Teacher teacher);

}
