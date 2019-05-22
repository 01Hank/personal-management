package com.pm.Controller;

import com.pm.Pojo.Teacher;
import com.pm.Service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private teacherService userService;

    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public Teacher login(@RequestParam("name") String name){
        return  userService.selectUserByName(name);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public int register(@RequestBody Teacher t){
        if(t.getRadio().equals("1")){
            Teacher teacherUser = new Teacher();
            teacherUser.setName(t.getName());
            teacherUser.setPwd(t.getPwd());
            int index = userService.saveUser(teacherUser);
            return  index;
        }
//        if(radio.equals("2")){
//
//        }
        return 0;
    }
}
