package com.AAA.csEban.service;

import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher selectById(int id);

    void launchNotice(int id,String content);

    int searchNoticeNum();

    List<Integer> searchStudentByGrade(String grade);

    void noticeToStudent(int num,int id);

    void handleNoticePush(int teacherId,String content,String grade);

    List<Request> getAbsentRequestById(int teacherId);

    List<Request> getLeaveRequestById(int teacherId);

    void agreeRequestById(int id);

    void disagreeRequestById(int id,String reason);
}
