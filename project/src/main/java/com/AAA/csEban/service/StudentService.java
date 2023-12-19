package com.AAA.csEban.service;

import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.Notice;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.pojo.Teacher;

import java.util.List;

public interface StudentService {
    public Student getStudentInfo(int studentId);//查看个人信息

    public List<Notice> getNoticeInfo(int deptId);//查看学校公告

    public Notice lookNotice(int studentId, int NoticeId);//确认已经查看

    public void submitAbsentRequest(AbsentRequest absentRequest);//提交请假申请

    public List<AbsentRequest> getAbsentRequestList(int studentId);//查看已经提交的请假申请

    public List<Teacher> getInstructorListByStudentId(int studentId);
}
