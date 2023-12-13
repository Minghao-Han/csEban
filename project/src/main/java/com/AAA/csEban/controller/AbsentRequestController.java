package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.Msg;
import com.AAA.csEban.Utils.String2LocalDateTime;
import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.RequestForm;
import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.RequestService;
import com.AAA.csEban.service.StudentService;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/student/absent")
@Controller
public class AbsentRequestController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    RequestService requestService;
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
        RequestForm requestForm = new RequestForm();
        requestForm.setName(student.getName());
        requestForm.setNclass(student.getNclass());
        requestForm.setStudentId(student.getStudentId());
        requestForm.setGrade(student.getGrade());
        requestForm.setDept(student.getDept().getName());
        requestForm.setInstructorList(studentService.getInstructorListByStudentId(stuId));
        model.addAttribute("leaveRequestForm", requestForm);
        return "studentPages/absentRequest";
    }
    @PostMapping
    @ResponseBody
    public String commitAbsentRequest(@RequestBody Map<String, Object> requestBody){
        Integer studentId = Integer.parseInt((String) requestBody.get("studentId"));
        Student student = studentService.getStudentInfo(studentId);
        String information = (String) requestBody.get("rationale");
        Integer instructorId = Integer.parseInt((String) requestBody.get("instructorId"));
        Teacher instructor = teacherService.selectById(instructorId);
        String courseName = (String) requestBody.get("courseName");
        String leaveTimeStartStr = (String) requestBody.get("leaveTimeStart");
        String leaveTimeEndStr = (String) requestBody.get("leaveTimeEnd");
        LocalDateTime startTime = String2LocalDateTime.transform(leaveTimeStartStr);
        LocalDateTime endTime = String2LocalDateTime.transform(leaveTimeEndStr);
        AbsentRequest absentRequest = new AbsentRequest();
        absentRequest.setStudent(student);
        absentRequest.setCourseName(courseName);
        absentRequest.setInformation(information);
        absentRequest.setTeacher(instructor);
        absentRequest.setStartTime(startTime);
        absentRequest.setEndTime(endTime);
        requestService.addAbsentRequest(absentRequest);
        return "ok";
    }
}
