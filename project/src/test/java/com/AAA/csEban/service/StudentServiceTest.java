package com.AAA.csEban.service;

import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void test1(){
        List<AbsentRequest> absentRequestList;
        List<Teacher> teacherList;
        studentService.lookNotice(2, 34);
        System.out.println(studentService.getStudentInfo(34));
        absentRequestList = studentService.getAbsentRequestList(34);
        teacherList = studentService.getInstructorListByStudentId(34);
        int a = 1;
    }
}
