package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AbsentRequest extends Request{
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
