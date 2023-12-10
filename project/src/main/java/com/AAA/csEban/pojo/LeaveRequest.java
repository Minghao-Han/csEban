package com.AAA.csEban.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LeaveRequest extends Request{
    private String leaveTime;
    private String returnTime;
    private String destination;
}
