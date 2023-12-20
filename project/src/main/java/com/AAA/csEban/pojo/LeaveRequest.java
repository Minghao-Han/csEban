package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LeaveRequest extends Request{
    private int requestId;
    private LocalDateTime leaveTime;
    private LocalDateTime returnTime;
    private String destination;
}
