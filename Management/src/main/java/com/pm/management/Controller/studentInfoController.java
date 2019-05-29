package com.pm.management.Controller;


import com.pm.management.Pojo.dao.Cla;
import com.pm.management.Pojo.dao.option;
import com.pm.management.Pojo.studentInfo;
import com.pm.management.Service.studentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class studentInfoController {

    @Autowired
    private studentInfoService stuInService;


    @CrossOrigin(origins = "*")
    @GetMapping("/getStuIn")
    public studentInfo  getstudentInfo(@RequestParam("sid") int sid){
        studentInfo studentInfo = stuInService.selectById(sid);
        return studentInfo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getTeacherList")
    public List<option>  getTeacherList(){
        List<option> teacherList = stuInService.getTeacherList();
        return  teacherList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/updateStudent")
    public void updateStudent(@RequestParam("sid") int sid,
                              @RequestParam("sname") String sname,
                              @RequestParam("sex") int sex,
                              @RequestParam("age") int age,
                              @RequestParam("bithday") String bithday,
                              @RequestParam("tid") String tid){

        int i = Integer.parseInt(tid);
        stuInService.updateStudentInfo(sid,sname,age,bithday,i,sex);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getClass")
    public Cla getClass(@RequestParam("sid") String sid){

        try {
            int i = Integer.parseInt(sid);
            Cla cl = stuInService.getClaByTid(i);
            return cl;
        }catch (Exception e){
            return new Cla();
        }

    }
}
