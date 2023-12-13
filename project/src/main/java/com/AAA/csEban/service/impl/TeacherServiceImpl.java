package com.AAA.csEban.service.impl;

import com.AAA.csEban.mapper.TeacherMapper;
import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public Teacher selectById(int id) {
        return teacherMapper.selectByTeacherId(id);
    }

    @Override
    public void launchNotice(int id,String content) {
        teacherMapper.insertNotice(id,content);
    }

    @Override
    public int searchNoticeNum() {
        return teacherMapper.queryNoticeNum();
    }

    @Override
    public List<Integer> searchStudentByGrade(String grade) {
        return teacherMapper.searchStudentByGrade(grade);
    }

    @Override
    public void noticeToStudent(int num, int id) {
        teacherMapper.noticeStudent(num,id);
    }

    @Override
    public void handleNoticePush(int teacherId, String content, String grade) {
        teacherMapper.insertNotice(teacherId,content);
        int num = teacherMapper.queryNoticeNum();
        List<Integer> list = teacherMapper.searchStudentByGrade(grade);
        for(int id:list){
            teacherMapper.noticeStudent(num,id);
        }
    }

    @Override
    public List<Request> getAbsentRequestById(int teacherId) {
        return teacherMapper.getAbsentRequestByTeacherId(teacherId);
    }

    @Override
    public List<Request> getLeaveRequestById(int teacherId) {
        return teacherMapper.getLeaveRequestByTeacherId(teacherId);
    }

    @Override
    public void agreeRequestById(int id) {
        teacherMapper.agreeRequestById(id);
    }

    @Override
    public void disagreeRequestById(int id, String reason) {
        teacherMapper.disagreeRequestById(id,reason);
    }
}
