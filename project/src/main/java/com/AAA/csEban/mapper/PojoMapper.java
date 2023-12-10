package com.AAA.csEban.mapper;


import com.AAA.csEban.pojo.Dept;
import com.AAA.csEban.pojo.Notice;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PojoMapper {

     List<Notice> queryNoticeListForTeacher(int id);

     Student queryStudentById(int id);

     Teacher queryTeacherNameById(int id);

     Dept queryDeptById(int id);

     Notice queryNoticeById(int id);

    Teacher selectTeacherById(int i);


//
//     int addAbsentRequest(AbsentRequest absentRequest);
//
//     int addLeaveRequest(LeaveRequest leaveRequest);


}
