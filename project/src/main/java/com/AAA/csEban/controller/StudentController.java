package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/info")
    public String showStudentInfo(@UserId int id){
        return studentService.getStudentInfo(id).toString();
    }
}
