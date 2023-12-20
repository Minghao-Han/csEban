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
        /*Teacher teacher = teacherService.selectById(1);
        System.out.println(teacher);*/
        System.out.println(teacherService.getAbsentRequestById(1111));
        System.out.println(teacherService.getLeaveRequestById(1111));
    }
    @Test
    public void testInsert(){
        //teacherService.launchNotice(1111,"test");
        //teacherService.noticeToStudent(4,34);
        //teacherService.handleNoticePush(1111,"testAll","2021");
        teacherService.submitTeacherInformation("计算机","yy");
    }
    @Test
    public void testUpdate(){
        teacherService.agreeRequestById(1);
        teacherService.disagreeRequestById(3,"不行");
    }
}
