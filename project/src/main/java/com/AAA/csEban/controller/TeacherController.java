package com.AAA.csEban.controller;

import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/searchById")
    public String searchTeacher(int id){
        return teacherService.selectById(id).toString();
    }

    @PostMapping("/teacher/launch")
    public void launchNotice(int id,String content,String grade){
        teacherService.launchNotice(id,content);
        int num = teacherService.searchNoticeNum();
        int deptId = teacherService.searchTeacherDeptIdByTeacherId(id);
        List<Integer> list = teacherService.searchStudentByGrade(grade,deptId);
        for(int sid : list){
            teacherService.noticeToStudent(num,sid);
        }
    }
    @GetMapping("teacher/getAbsentRequest")
    public List<Request> getAbsentRequestById(int teacherId){
        return teacherService.getAbsentRequestById(teacherId);
    }
    @PostMapping("/teacher/agree")
    public void agree(int id){
        teacherService.agreeRequestById(id);
    }
    @PostMapping("/teacher/disagree")
    public void disagree(int id,String str){
        teacherService.disagreeRequestById(id,str);
    }
    @PostMapping("/teacher/submit")
    public void submit(String teacherName,String deptName){
        teacherService.submitTeacherInformation(deptName,teacherName);
    }
}
