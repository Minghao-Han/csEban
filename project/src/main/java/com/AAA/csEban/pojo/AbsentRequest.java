package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AbsentRequest extends Request{
    private int requestId;
    protected Teacher teacher;//负责审核的老师，一般是学生学院的导师
    protected Student student;//发起请求的学生
    protected String information;
    protected int isAgree = -1; //取三个值-1  0   1；-1表示没有审核或者还在审核中。0表示拒绝，1表示同意
    protected String refuseInformation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String courseName;

    @Override
    public String toString() {
        return "AbsentRequest{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", courseName='" + courseName + '\'' +
                ", requestId=" + requestId +
                ", teacher=" + teacher +
                ", student=" + student +
                ", information='" + information + '\'' +
                ", isAgree=" + isAgree +
                ", refuseInformation='" + refuseInformation + '\'' +
                ", type=" + type +
                '}';
    }
}
