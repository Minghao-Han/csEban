package com.AAA.csEban.service;

import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.LeaveRequest;

import java.util.List;

public interface RequestService {
    public void addAbsentRequest(AbsentRequest absentRequest);
    public List<AbsentRequest> selectAbsentRequestByStuId(int stuId);
    public void addLeaveRequest(LeaveRequest leaveRequest);
    public List<AbsentRequest> selectLeaveRequestByStuId(int stuId);
}
