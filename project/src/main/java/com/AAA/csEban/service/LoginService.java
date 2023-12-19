package com.AAA.csEban.service;

import com.AAA.csEban.mapper.StuAccountMapper;
import com.AAA.csEban.mapper.TeacherAccountMapper;
import com.AAA.csEban.pojo.StudentAccount;
import com.AAA.csEban.pojo.TeacherAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private StuAccountMapper stuAccountMapper;
    @Autowired
    private TeacherAccountMapper teacherAccountMapper;

    public Boolean verifyAccount(int userId,String password,String role){
        switch (role){
            case "teacher":
                TeacherAccount teacherAccount = teacherAccountMapper.selectAccountById(userId);
                if (teacherAccount==null) return false;
                if (password.equals(teacherAccount.getPassword())) return true;
                return false;
            case "student":
                StudentAccount studentAccount=stuAccountMapper.selectAccountById(userId);
                if (studentAccount==null) return false;
                if (password.equals(studentAccount.getPassword())) return true;
                return false;
            default:
                return false;
        }
    }
}
