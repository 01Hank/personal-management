package com.pm.Service;

import com.pm.Pojo.Student;


public interface studentService {
    Student selectUserByName(String name);

    int  saveUser(Student student);
}
