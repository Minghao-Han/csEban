package com.AAA.csEban.controller;

import com.AAA.csEban.Utils.JwtUtils;
import com.AAA.csEban.formObjs.LoginUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUser loginUser, Model model, HttpSession session){
        /**validate username,password and role*/
        System.out.println(loginUser.toString());
        if (true){
            String jwt = JwtUtils.generateJwt(0,loginUser.getRole());
            session.setAttribute("jwt",jwt);
            switch (loginUser.getRole()){
                case "teacher": return "teacherPages/teacherHome";
                case "student":
                    model.addAttribute("loginUser",loginUser);
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