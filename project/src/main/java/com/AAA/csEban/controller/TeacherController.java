package com.AAA.csEban.controller;

import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public String searchTeacher(int id){
        return teacherService.selectById(id).toString();
    }
}
