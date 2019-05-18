package com.pm.Controller;

import com.pm.Pojo.User;
import com.pm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> selectAll(){
        return  userService.selectUser();
    }
}
