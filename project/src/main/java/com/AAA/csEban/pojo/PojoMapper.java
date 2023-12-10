package com.AAA.csEban.pojo;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PojoMapper {

     List<Notice> queryNoticeListForTeacher(int id);

     Student queryStudentById(int id);

     Teacher queryTeacherById(int id);

     Dept queryDeptById(int id);

     Notice queryNoticeById(int id);


//
//     int addAbsentRequest(AbsentRequest absentRequest);
//
//     int addLeaveRequest(LeaveRequest leaveRequest);


}
