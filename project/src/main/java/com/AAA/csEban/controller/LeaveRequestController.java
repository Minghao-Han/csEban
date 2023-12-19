package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.Msg;
import com.AAA.csEban.Utils.DateUtils;
import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.RequestForm;
import com.AAA.csEban.formObjs.RequestHistoryForm;
import com.AAA.csEban.pojo.*;
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

@RequestMapping("/student/leave")
@Controller
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
    public String commitLeaveRequest(@RequestBody Map<String, Object> requestBody,@UserId Integer studentId){
        Student student = studentService.getStudentInfo(studentId);

        String information1 = (String) requestBody.get("rationale");
        String information2 = (String) requestBody.get("rationaleElaboration");

        String destination = (String) requestBody.get("destination");

        Integer instructorId = Integer.parseInt((String) requestBody.get("instructorId"));
        Teacher instructor = teacherService.selectById(instructorId);

        String leaveTimeStr = (String) requestBody.get("leaveTime");
        String returnTimeStr = (String) requestBody.get("returnTime");
        LocalDateTime leaveTime = DateUtils.String2LocalDateTime(leaveTimeStr);
        LocalDateTime returnTime = DateUtils.String2LocalDateTime(returnTimeStr);

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStudent(student);
        leaveRequest.setInformation(information1+":"+information2);
        leaveRequest.setTeacher(instructor);
        leaveRequest.setLeaveTime(leaveTime);
        leaveRequest.setReturnTime(returnTime);
        leaveRequest.setDestination(destination);
        leaveRequest.setType(RequestType.E_LeaveRequest_Type);
        System.out.println(leaveRequest);
        requestService.addLeaveRequest(leaveRequest);
        return "ok";
    }
    @GetMapping("/history")
    public String getLeaveRequestHistory(@UserId Integer stuId,Model model){
        List<LeaveRequest> leaveRequestList = requestService.selectLeaveRequestByStuId(stuId);
        List<RequestHistoryForm> leaveRequestHistory = new ArrayList<>();
        for (LeaveRequest lr:leaveRequestList) {
            leaveRequestHistory.add(new RequestHistoryForm(lr));
        }
        model.addAttribute("leaveRequestHistory",leaveRequestHistory);
        return "studentPages/leaveRequestHistory";
    }
}
