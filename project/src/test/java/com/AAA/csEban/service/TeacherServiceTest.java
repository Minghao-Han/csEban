package com.AAA.csEban.service;

import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.impl.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherServiceImpl teacherService;

    @Test
    public void testSelect(){
        Teacher teacher = teacherService.selectById(1);
        System.out.println(teacher);
    }
}
