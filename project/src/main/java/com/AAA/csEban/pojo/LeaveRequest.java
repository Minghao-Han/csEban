package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LeaveRequest extends Request{
    private LocalDateTime leaveTime;
    private LocalDateTime returnTime;
    private String destination;

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "leaveTime=" + leaveTime +
                ", returnTime=" + returnTime +
                ", destination='" + destination + '\'' +
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
