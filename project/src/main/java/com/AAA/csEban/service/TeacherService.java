package com.AAA.csEban.service;

import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher selectById(int id);

    void launchNotice(int id,String content);

    void submitTeacherInformation(String deptName,String teacherName);

    int searchNoticeNum();

    List<Integer> searchStudentByGrade(String grade,int deptId);

    void noticeToStudent(int num,int id);

    void handleNoticePush(int teacherId,String content,String grade);

    List<Request> getAbsentRequestById(int teacherId);

    List<Request> getLeaveRequestById(int teacherId);

    void agreeRequestById(int id);

    void disagreeRequestById(int id,String reason);

    int searchTeacherDeptIdByTeacherId(int id);
}
