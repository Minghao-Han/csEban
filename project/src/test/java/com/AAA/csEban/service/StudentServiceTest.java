package com.AAA.csEban.service;

import com.AAA.csEban.pojo.*;
import com.AAA.csEban.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private RequestService requestService;
    @Test
    public void test1(){
        List<AbsentRequest> absentRequestList;
        List<Teacher> teacherList;
        List<LeaveRequest> leaveRequestList;
        List<Notice> noticeList;
        studentService.lookNotice(2, 34);
        System.out.println(studentService.getStudentInfo(34));
        absentRequestList = studentService.getAbsentRequestList(34);
        teacherList = studentService.getInstructorListByStudentId(34);

//        LeaveRequest leaveRequest = new LeaveRequest();
//        leaveRequest.setStudent(studentService.getStudentInfo(34));
//        leaveRequest.setInformation("离校回家");
//        leaveRequest.setTeacher(teacherList.get(0));
//        leaveRequest.setLeaveTime(LocalDateTime.of(2023,12,11,22,20));
//        leaveRequest.setReturnTime(LocalDateTime.of(2023,12,11,22,20));
//        leaveRequest.setDestination("四川");
//        leaveRequest.setType(RequestType.E_LeaveRequest_Type);
//        requestService.addLeaveRequest(leaveRequest);
        leaveRequestList = requestService.selectLeaveRequestByStuId(34);
        noticeList = studentService.getNoticeInfo(1);
        int a = 1;
    }
}
