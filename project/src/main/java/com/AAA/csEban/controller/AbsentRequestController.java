package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.Msg;
import com.AAA.csEban.Utils.DateUtils;
import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.RequestForm;
import com.AAA.csEban.formObjs.RequestHistoryForm;
import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.RequestType;
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
import java.util.ArrayList;
import java.util.List;
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
        model.addAttribute("absentRequestForm", requestForm);
        return "studentPages/absentRequest";
    }
    @PostMapping
    @ResponseBody
    public String commitAbsentRequest(@RequestBody Map<String, Object> requestBody,@UserId Integer studentId){
        Student student = studentService.getStudentInfo(studentId);
        String information = (String) requestBody.get("rationale");
        Integer instructorId = Integer.parseInt((String) requestBody.get("instructorId"));
        Teacher instructor = teacherService.selectById(instructorId);
        String courseName = (String) requestBody.get("courseName");
        String absentTimeStartStr = (String) requestBody.get("absentTimeStart");
        String absentTimeEndStr = (String) requestBody.get("absentTimeEnd");
        LocalDateTime startTime = DateUtils.String2LocalDateTime(absentTimeStartStr);
        LocalDateTime endTime = DateUtils.String2LocalDateTime(absentTimeEndStr);
        AbsentRequest absentRequest = new AbsentRequest();
        absentRequest.setStudent(student);
        absentRequest.setCourseName(courseName);
        absentRequest.setInformation(information);
        absentRequest.setTeacher(instructor);
        absentRequest.setStartTime(startTime);
        absentRequest.setEndTime(endTime);
        absentRequest.setType(RequestType.E_AbsentRequest_Type);
        requestService.addAbsentRequest(absentRequest);
        return "ok";
    }
    @GetMapping("/history")
    public String getAbsentRequestHistory(@UserId Integer stuId,Model model){
        stuId=34;
        List<AbsentRequest> absentRequestList = studentService.getAbsentRequestList(stuId);
        List<RequestHistoryForm> absentRequestHistory = new ArrayList<>();
        for (AbsentRequest aR:absentRequestList) {
            absentRequestHistory.add(new RequestHistoryForm(aR));
        }
        model.addAttribute("absentRequestHistory",absentRequestHistory);
        return "studentPages/absentRequestHistory";
    }
}
