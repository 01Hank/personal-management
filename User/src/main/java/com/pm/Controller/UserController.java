package com.pm.Controller;

import com.pm.Pojo.Student;
import com.pm.Pojo.Teacher;
import com.pm.Service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pm.Service.studentService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private teacherService userService;
    @Autowired
    private studentService stu;

    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public ResponseEntity login(@RequestParam("name") String name){

        Teacher teacher = userService.selectUserByName(name);
        if(teacher==null){
            Student student = stu.selectUserByName(name);
            if(student==null){
                return ResponseEntity.ok(1);
            }
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.ok(teacher);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public int register(@RequestBody Teacher t){
        if(t.getRadio().equals("1")){
//            Teacher teacherUser = new Teacher();
//            teacherUser.setName(t.getName());
//            teacherUser.setPwd(t.getPwd());
            return userService.saveUser(t);
        }
        if(t.getRadio().equals("2")){
            Student student = new Student();
            student.setName(t.getName());
            student.setPwd(t.getPwd());
            return stu.saveUser(student);

        }
        return 0;
    }
}
