package com.pm.Controller;

import com.pm.Pojo.teacherUser;
import com.pm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public teacherUser selectAll(@RequestParam("name") String name){
        return  userService.selectUserByName(name);
    }
}
