package com.pm.Controller;

import com.pm.Mapper.UserMapper;
import com.pm.Pojo.MaiaUser;
import com.pm.Pojo.db.Login;
import com.pm.Pojo.db.Register;
import com.pm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @CrossOrigin("*")
    public void  getUser(@RequestBody Register registerUser){
        MaiaUser maiaUser = new MaiaUser();
       // String invitation_code = registerUser.getInvitation_code();//邀请码

        maiaUser.setFirstName(registerUser.getUsername().split(",")[0]);
        maiaUser.setLastName(registerUser.getUsername().split(",")[1]);
        maiaUser.setPassword(registerUser.getPassword());
        maiaUser.setEmail(registerUser.getEmail_address());
        maiaUser.setType(Integer.valueOf(registerUser.getType()));
        userService.register(maiaUser);
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public  String  login(@RequestBody String logins){

        return  null;
    }

}
