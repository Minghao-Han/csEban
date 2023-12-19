package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.JwtUtils;
import com.AAA.csEban.formObjs.LoginUser;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.service.LoginService;
import com.AAA.csEban.service.StudentService;
import com.AAA.csEban.service.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUser loginUser, Model model, HttpSession session){
        /**validate username,password and role*/
        Integer userId = null;
        try{
            userId = Integer.parseInt(loginUser.getUsername());
        }catch (Exception e){
            return "loginPage";
        }
        if (userId!=null && loginService.verifyAccount(userId, loginUser.getPassword(),loginUser.getRole())){
            String jwt = JwtUtils.generateJwt(userId,loginUser.getRole());
            session.setAttribute("jwt",jwt);
            switch (loginUser.getRole()){
                case "teacher":
                    model.addAttribute("loginUser",loginUser);
                    model.addAttribute("name",teacherService.selectById(userId).getTeacherName());
                    return "teacherPages/teacherHome";
                case "student":
                    model.addAttribute("loginUser",loginUser);
                    model.addAttribute("name",studentService.getStudentInfo(userId).getName());
                    return "studentPages/stuHome";
                default:
                    model.addAttribute("msg","错误的角色");
                    return "error";
            }
        }else {
            return "loginPage";
        }
    }
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("loginUser",new LoginUser());
        return "loginPage";
    }

}
