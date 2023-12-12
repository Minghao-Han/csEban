package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.StudentAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuAccountMapper {
    public StudentAccount selectAccountById(int id);
}
