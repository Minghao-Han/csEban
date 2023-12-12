package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
    private int studentId;
    private Dept dept;
    private String name;
    private String nclass;
    private String grade;


}
