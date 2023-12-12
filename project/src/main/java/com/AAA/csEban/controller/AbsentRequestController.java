package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.Msg;
import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.LeaveRequestForm;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RequestMapping("/student/absent")
@Controller
public class AbsentRequestController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public String getAbsentRequestPage(@UserId Integer stuId, Model model){
        if (stuId==null){
            model.addAttribute("Msg",new Msg("student not exist",300));
            return "error";
        }
        Student student = studentService.getStudentInfo(stuId);
        if (student==null){
            model.addAttribute("Msg",new Msg("student not exist",300));
            return "error";
        }
        LeaveRequestForm leaveRequestForm = new LeaveRequestForm();
        leaveRequestForm.setName(student.getName());
        leaveRequestForm.setNclass(student.getNclass());
        leaveRequestForm.setStudentId(student.getStudentId());
        leaveRequestForm.setGrade(student.getGrade());
        leaveRequestForm.setDept(student.getDept().getName());
        model.addAttribute("leaveRequestForm",leaveRequestForm);
        return "studentPages/absentRequest";
    }
    @PostMapping
    @ResponseBody
    public String commitAbsentRequest(@RequestBody Map<String, Object> requestBody){
        Integer StudentId = (Integer) requestBody.get("stNo");


    }
}
