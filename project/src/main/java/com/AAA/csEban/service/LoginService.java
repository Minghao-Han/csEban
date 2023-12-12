package com.AAA.csEban.service;

import com.AAA.csEban.mapper.StuAccountMapper;
import com.AAA.csEban.pojo.StudentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private StuAccountMapper stuAccountMapper;

    public Boolean verifyAccount(int student_id,String password){
        StudentAccount studentAccount=stuAccountMapper.selectAccountById(student_id);
        if (password.equals(studentAccount.getPassword())) return true;
        return false;
    }
}
