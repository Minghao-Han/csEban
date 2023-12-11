package com.AAA.csEban.pojo;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PojoMapper {

     public List<Notice> queryNoticeListForTeacher(int id);

     public Student queryStudentById(int id);

     public Teacher queryTeacherById(int id);

     public Dept queryDeptById(int id);

     public Notice queryNoticeById(int id);



//     int addAbsentRequest(AbsentRequest absentRequest);
//
//     int addLeaveRequest(LeaveRequest leaveRequest);


}
