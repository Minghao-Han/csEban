package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.RequestForm;
import com.AAA.csEban.formObjs.RequestCheckForm;
import com.AAA.csEban.mapper.PojoMapper;
import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PojoMapper pojoMapper;

    @GetMapping("/searchById")
    public String searchTeacher(@UserId int id){
        return teacherService.selectById(id).toString();
    }
    @GetMapping("/info")
    public String getPersonalInfo(@UserId int teacherId,Model model){
        Teacher teacher = teacherService.selectById(teacherId);
        model.addAttribute("teacherInfo",teacher);
        String deptName = pojoMapper.queryDeptById(teacher.getDeptId()).getName();
        model.addAttribute("deptName",deptName);
        return "teacherPages/teacherInfo";
    }

    @GetMapping("/launch")
    public String getNoticeLaunchPage(){
        return "teacherPages/launchNotice";
    }
    @PostMapping("/launch")
    @ResponseBody
    public void launchNotice(@UserId int id,@RequestBody Map<String,String> requestBody){
        String content = requestBody.get("content");
        String grade = requestBody.get("grade");
        if (content==null || grade==null) {
            throw new RuntimeException("content and grade are required when launch a notice");
        }
        teacherService.launchNotice(id,content);
        int num = teacherService.searchNoticeNum();
        List<Integer> list = teacherService.searchStudentByGrade(grade);
        for(int sid : list){
            teacherService.noticeToStudent(num,sid);
        }
    }
    @GetMapping("/absentRequest")
    public String getAbsentRequestById(@UserId int teacherId, Model model){
        List<Request> requests = teacherService.getAbsentRequestById(teacherId);
        List<RequestCheckForm> absentRequests = new ArrayList<>();
        for (Request request :
                requests) {
            absentRequests.add(new RequestCheckForm(request));
        }
        model.addAttribute("absentRequests",absentRequests);
        return "teacherPages/absentRequest";
    }

    @GetMapping("/leaveRequest")
    public String getLeaveRequestById(@UserId int teacherId, Model model){
        List<Request> requests = teacherService.getLeaveRequestById(teacherId);
        List<RequestCheckForm> leaveRequests = new ArrayList<>();
        for (Request request :
                requests) {
            leaveRequests.add(new RequestCheckForm(request));
        }
        model.addAttribute("leaveRequests",leaveRequests);
        return "teacherPages/leaveRequest";
    }

    @PutMapping("/request/approve")
    @ResponseBody
    public String approve(@RequestBody Map<String,String> requestBody){
        Integer id = null;
        try {
            id = Integer.parseInt(requestBody.get("requestId"));
        }catch (Exception e) {
            throw new RuntimeException("exception caught in /request/approve");
        }
        if (id == null) {
            return "failed, id is required.";
        }
        teacherService.agreeRequestById(id);
        return "ok";
    }
    @PutMapping("/request/reject")
    @ResponseBody
    public String reject(@RequestBody Map<String,String> requestBody){
        Integer id = null;
        String str = null;
        try {
            id = Integer.parseInt(requestBody.get("requestId"));
            str = requestBody.get("refuseInformation");
        }catch (Exception e) {
            return "failed "+e.toString();
        }
        if (id == null || str == null) {
            return "failed, id and refuseInformation are required.";
        }
        teacherService.disagreeRequestById(id,str);
        return "ok";
    }
}
