package com.AAA.csEban.service.impl;

import com.AAA.csEban.mapper.TeacherMapper;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public Teacher selectById(int id) {
        return teacherMapper.selectByTeacherId(id);
    }
}
