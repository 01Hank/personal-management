package com.pm.management.Service.Impl;

import com.pm.management.Mapper.homeworkMapper;
import com.pm.management.Pojo.homework;
import com.pm.management.Service.homeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class homeworkServiceImpl implements homeworkService {
    @Autowired
    private homeworkMapper  homework;

    @Transactional
    @Override
    public List<homework> getHomeworkByTid(int tid) {
        List<homework> list = homework.getByTid(tid);

        return list;
    }
}
