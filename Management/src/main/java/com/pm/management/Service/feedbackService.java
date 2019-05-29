package com.pm.management.Service;

import com.pm.management.Pojo.feedback;

import java.util.List;

public interface feedbackService {
    List<feedback> getAllFeedBack(int sid);

    void deletByIds(String[] split);

    void saveFeedback(feedback fee);
}
