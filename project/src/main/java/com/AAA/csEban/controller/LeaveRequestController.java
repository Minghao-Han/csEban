package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.Msg;
import com.AAA.csEban.Utils.String2LocalDateTime;
import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.RequestForm;
import com.AAA.csEban.pojo.*;
import com.AAA.csEban.service.RequestService;
import com.AAA.csEban.service.StudentService;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/student/leave")
public class LeaveRequestController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    RequestService requestService;
    @GetMapping
    public String getLeaveRequestPage(@UserId Integer stuId, Model model){
        if (stuId==null){
            model.addAttribute("Msg",new Msg("student not exist",300));
            return "error";
        }
        Student student = studentService.getStudentInfo(stuId);
        if (student==null){
            model.addAttribute("Msg",new Msg("student not exist",300));
            return "error";
        }
        RequestForm requestForm = new RequestForm();
        requestForm.setName(student.getName());
        requestForm.setNclass(student.getNclass());
        requestForm.setStudentId(student.getStudentId());
        requestForm.setGrade(student.getGrade());
        requestForm.setDept(student.getDept().getName());
        requestForm.setInstructorList(studentService.getInstructorListByStudentId(stuId));
        model.addAttribute("leaveRequestForm", requestForm);
        return "studentPages/leaveRequest";
    }
    @PostMapping
    @ResponseBody
    public String commitLeaveRequest(@RequestBody Map<String, Object> requestBody){
        Integer studentId = Integer.parseInt((String) requestBody.get("studentId"));
        Student student = studentService.getStudentInfo(studentId);
        String information = (String) requestBody.get("rationale");
        Integer instructorId = Integer.parseInt((String) requestBody.get("instructorId"));
        Teacher instructor = teacherService.selectById(instructorId);
        String leaveTimeStartStr = (String) requestBody.get("leaveTimeStart");
        String leaveTimeEndStr = (String) requestBody.get("leaveTimeEnd");
        LocalDateTime startTime = String2LocalDateTime.transform(leaveTimeStartStr);
        LocalDateTime endTime = String2LocalDateTime.transform(leaveTimeEndStr);
        LeaveRequest leaveRequest = new LeaveRequest();

        leaveRequest.setType(RequeseType.E_LeaveRequest_Type);
        leaveRequest.setLeaveTime(startTime);
        leaveRequest.setReturnTime(endTime);
        leaveRequest.setTeacher(instructor);
        leaveRequest.setStudent(student);
        leaveRequest.setInformation(information);

        return "ok";
    }
}
