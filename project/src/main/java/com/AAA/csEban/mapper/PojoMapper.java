package com.AAA.csEban.mapper;


import com.AAA.csEban.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PojoMapper {

     List<Teacher> queryTeacherListForDept(int id);

     List<Teacher> queryInstructorListForDept(int id);

     List<AbsentRequest> queryAbsentRequestList(int studentId);

     List<LeaveRequest> queryLeaveRequestList(int studentId);

     Student queryStudentById(int id);

     Teacher queryTeacherById(int id);

     Dept queryDeptById(int id);

     Notice queryNoticeById(int id);

     Teacher selectTeacherById(int id);




//
//
//
//     int addLeaveRequest(LeaveRequest leaveRequest);
     void updateStudentLookNotice(int noticeId, int studentId);

     void addAbsentRequest(AbsentRequest absentRequest);

     void addLeaveRequest(LeaveRequest leaveRequest);

     void addRequest(Request request);


}
