package com.pm.Service;


import com.pm.Pojo.Teacher;

public interface teacherService {

    Teacher selectUserByName(String name);

      int  saveUser(Teacher teacher);

}
