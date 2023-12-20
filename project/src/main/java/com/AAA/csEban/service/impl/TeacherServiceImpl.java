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
    public void submitTeacherInformation(String deptName, String teacherName) {
        int deptId = teacherMapper.queryDeptIdByName(deptName);
        teacherMapper.insertTeacherInformation(deptId,teacherName);
    }

    @Override
    public int searchNoticeNum() {
        return teacherMapper.queryNoticeNum();
    }

    @Override
    public List<Integer> searchStudentByGrade(String grade,int deptId) {
        return teacherMapper.searchStudentByGradeAndDept(grade,deptId);
    }

    @Override
    public void noticeToStudent(int num, int id) {
        teacherMapper.noticeStudent(num,id);
    }

    @Override
    public void handleNoticePush(int teacherId, String content, String grade) {
        teacherMapper.insertNotice(teacherId,content);
        int num = teacherMapper.queryNoticeNum();
        int deptId = teacherMapper.searchTeacherDeptById(teacherId);
        List<Integer> list = teacherMapper.searchStudentByGradeAndDept(grade,deptId);
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

    @Override
    public int searchTeacherDeptIdByTeacherId(int id) {
        return teacherMapper.searchTeacherDeptById(id);
    }
}
