package com.AAA.csEban.service.impl;

import com.AAA.csEban.mapper.PojoMapper;
import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.LeaveRequest;
import com.AAA.csEban.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    PojoMapper pojoMapper;
    @Override
    public void addAbsentRequest(AbsentRequest absentRequest) {
        pojoMapper.addRequest(absentRequest);
        pojoMapper.addAbsentRequest(absentRequest);
    }

    @Override
    public List<AbsentRequest> selectAbsentRequestByStuId(int stuId) {
        return pojoMapper.queryAbsentRequestList(stuId);
    }

    @Override
    public void addLeaveRequest(LeaveRequest leaveRequest) {
        pojoMapper.addRequest(leaveRequest);
        pojoMapper.addLeaveRequest(leaveRequest);
    }

    @Override
    public List<LeaveRequest> selectLeaveRequestByStuId(int stuId) {
        return pojoMapper.queryLeaveRequestList(stuId);
    }


}
