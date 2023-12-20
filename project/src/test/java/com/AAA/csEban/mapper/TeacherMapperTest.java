package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;
    /*@Autowired
    private PojoMapper pojoMapper;*/

    @Test
    public void testSelect(){
        Teacher teacher = teacherMapper.selectByTeacherId(1);
        //Teacher teacher = pojoMapper.selectTeacherById(1);
        System.out.println(teacher);
    }
    @Test
    public void testInsert(){
        System.out.println(teacherMapper.queryDeptIdByName("计算机"));
    }
}
