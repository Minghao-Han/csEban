package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface TeacherMapper{

    //@Select("select * from cseban.teacher where teacher_id=#{id}")
    Teacher selectByTeacherId(int id);
}
