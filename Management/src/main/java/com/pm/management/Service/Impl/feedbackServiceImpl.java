package com.pm.management.Service.Impl;



import com.pm.management.Mapper.feedbackMapper;
import com.pm.management.Pojo.feedback;
import com.pm.management.Service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class feedbackServiceImpl implements feedbackService {

    @Autowired
    private feedbackMapper  feedMapper;


    @Transactional
    @Override
    public List<feedback>  getAllFeedBack(int sid){
        List<feedback> allFeedbackBySid = feedMapper.getAllFeedbackBySid(sid);
        return allFeedbackBySid;
    }

    @Transactional
    @Override
    public void deletByIds(String[] split) {
        int index = 0;
        for(int i=1;i<split.length;i++){
             index = Integer.parseInt(split[i]);
            feedMapper.deletById(index);
            index = 0;
        }
    }

    @Transactional
    @Override
    public void saveFeedback(feedback fee) {
//        feedMapper.insert(fee.getBack_time(),fee.getNoclean(),fee.getSelfcheck(),fee.getPlan(),fee.getLevel(),fee.getSid());
        //feedMapper.insertSelective(fee);
        feedMapper.insertFeedback(fee.getBack_time(),fee.getNoclean(),fee.getSelfcheck(),fee.getPlan(),fee.getLevel(),fee.getSid());

    }
}
