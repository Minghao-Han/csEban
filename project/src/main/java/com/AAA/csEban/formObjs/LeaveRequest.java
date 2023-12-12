package com.AAA.csEban.formObjs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
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
}
