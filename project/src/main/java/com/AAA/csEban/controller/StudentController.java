package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.UserId;
import com.AAA.csEban.formObjs.NoticeForm;
import com.AAA.csEban.pojo.Notice;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.service.StudentService;
import com.AAA.csEban.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("/student/info")
    public String showStudentInfo(@UserId int id, Model model){
        Student studentInfo = studentService.getStudentInfo(id);
        model.addAttribute("studentInfo",studentInfo);
        return "studentPages/studentInfo";
    }
    @GetMapping("/student/notice")
    public String getNotices(@UserId int stuId, Model model){
        Student studentInfo = studentService.getStudentInfo(stuId);
        List<Notice> noticeInfo = studentService.getNoticeInfo(studentInfo.getDept().getDeptId());
        List<NoticeForm> notices = new ArrayList<>();
        for (Notice notice :
                noticeInfo) {
            String posterName = teacherService.selectById(Integer.parseInt(notice.getTeacherId())).getTeacherName();
            notices.add(new NoticeForm(notice.getNoticeId(),notice.getContent(),posterName));
        }
        model.addAttribute("notices",notices);
        return "studentPages/notice";
    }

    @ResponseBody
    @PutMapping("/student/notice")
    public String checkedNotice(@UserId Integer stuId, @RequestBody Map<String,Object> requestBody){
        Integer noticeId =null;
        try{
            noticeId = (Integer) requestBody.get("noticeId");
        }catch (Exception e){
            return "failed";
        }
        if (noticeId==null) return "failed";
        studentService.lookNotice(stuId,noticeId);
        return "ok";
    }
}
