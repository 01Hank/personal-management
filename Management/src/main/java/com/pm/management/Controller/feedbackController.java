package com.pm.management.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pm.management.Pojo.feedback;
import com.pm.management.Service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class feedbackController {
    @Autowired
    private feedbackService feedService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getFeedback")
    public PageInfo<feedback> getFeedback(@RequestParam("sid") int sid,
                                   @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum){
        PageHelper.startPage(pageNum,5);
        List<feedback> allFeedBack = feedService.getAllFeedBack(sid);
        PageInfo<feedback> objectPageInfo = new PageInfo<>(allFeedBack);
        return objectPageInfo;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/deletData")
    public void deletData(@RequestParam("sids") String sids){
        String[] split = sids.split("-");
        feedService.deletByIds(split);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveFeedback")
    public void saveFeedback(@RequestBody feedback fee){
        feedService.saveFeedback(fee);
    }
}
