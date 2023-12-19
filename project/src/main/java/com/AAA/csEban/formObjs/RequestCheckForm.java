package com.AAA.csEban.formObjs;

import com.AAA.csEban.Utils.DateUtils;
import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.LeaveRequest;
import com.AAA.csEban.pojo.Request;
import com.AAA.csEban.pojo.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCheckForm {
    private int requestId;
    private int studentId;
    private String studentName;
    private String instructorName;
    private String information;
    private String startTime;
    private String endTime;
    private int isAgree = -1; //取三个值-1  0   1；-1表示没有审核或者还在审核中。0表示拒绝，1表示同意
    private String refuseInformation;
    private String destination;
    private String courseName;

    public RequestCheckForm(Request request) {
        this.requestId = request.getRequestId();
        this.studentId = request.getStudent().getStudentId();
        this.studentName = request.getStudent().getName();
        this.instructorName = request.getTeacher().getTeacherName();
        this.information = request.getInformation();
        this.isAgree = request.getIsAgree();
        this.refuseInformation = request.getRefuseInformation();
        if (request.getType().equals(RequestType.E_AbsentRequest_Type)){
            AbsentRequest absentRequest = (AbsentRequest) request;
            this.startTime = DateUtils.LocalDateTime2String(absentRequest.getStartTime());
            this.endTime = DateUtils.LocalDateTime2String(absentRequest.getEndTime());
            this.courseName = absentRequest.getCourseName();
        }else {
            LeaveRequest leaveRequest = (LeaveRequest) request;
            this.startTime = DateUtils.LocalDateTime2String(leaveRequest.getLeaveTime());
            this.endTime = DateUtils.LocalDateTime2String(leaveRequest.getReturnTime());
            this.destination = leaveRequest.getDestination();
        }
    }
}
