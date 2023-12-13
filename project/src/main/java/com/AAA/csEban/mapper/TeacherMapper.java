package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TeacherMapper{

    //@Select("select * from cseban.teacher where teacher_id=#{id}")
    Teacher selectByTeacherId(int id);

    void insertNotice(int teacherId,String content);

    int queryNoticeNum();

    List<Integer> searchStudentByGrade(String grade);

    void noticeStudent(int num,int id);

    List<Request> getAbsentRequestByTeacherId(int id);

    List<Request> getLeaveRequestByTeacherId(int id);

    void agreeRequestById(int requestID);

    void disagreeRequestById(int requestID,String reason);
}
