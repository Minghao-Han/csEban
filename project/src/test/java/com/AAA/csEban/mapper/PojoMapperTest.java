package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
public class PojoMapperTest {
    @Autowired
    private PojoMapper pojoMapper;

    @Test
    public void test1(){
        Student student = pojoMapper.queryStudentById(34);
        Teacher teacher = pojoMapper.queryTeacherById(1111);
        List<Teacher> teacherList = pojoMapper.queryTeacherListForDept(1);
        int a = 0;
        System.out.println(student);
        System.out.println(teacher);
        System.out.println(teacherList);

        AbsentRequest absentRequest = new AbsentRequest();
        absentRequest.setCourseName("数学");
        absentRequest.setInformation("我要请假");
        absentRequest.setStudent(student);
        absentRequest.setTeacher(teacher);
        absentRequest.setType(RequeseType.E_AbsentRequest_Type);
        absentRequest.setStartTime(LocalDateTime.of(2023,12,11,21,25,40 ));
        absentRequest.setEndTime(LocalDateTime.of(2023,12,11,22,20 ));
        pojoMapper.addRequest(absentRequest);
        pojoMapper.addAbsentRequest(absentRequest);
    }
}
