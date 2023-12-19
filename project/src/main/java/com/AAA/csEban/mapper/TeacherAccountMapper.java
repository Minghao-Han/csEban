package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.TeacherAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherAccountMapper {
    public TeacherAccount selectAccountById(int id);
}
