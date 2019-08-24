package com.pm.management.Controller;

import com.pm.management.Pojo.homework;
import com.pm.management.Service.homeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class homeworkController {
    @Autowired
    private homeworkService homeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getListHomework")
    public List<homework> getListHomework(int tid){
        List<homework> homeworkList = homeService.getHomeworkByTid(tid);
        return homeworkList;
    }
}
