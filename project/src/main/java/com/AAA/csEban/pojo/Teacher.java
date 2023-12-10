package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Teacher {
    private int teacherId;
    private String teacherName;
    private int deptId;

    private List<Notice> noticeList = new LinkedList<>();
}
