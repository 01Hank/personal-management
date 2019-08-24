package com.pm.management.Service;

import com.pm.management.Pojo.homework;

import java.util.List;

public interface homeworkService {

    List<homework> getHomeworkByTid(int tid);
}
