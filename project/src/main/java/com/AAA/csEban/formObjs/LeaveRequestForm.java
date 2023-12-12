package com.AAA.csEban.formObjs;

import com.AAA.csEban.pojo.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestForm {
    int studentId;
    String name;
    String grade;
    String dept;
    String nclass;
    String leaveTimeStart;
    String leaveTimeEnd;
    String teacherName;
    String courseName;
    String rationale;
    List<Teacher> instructorList;
}
