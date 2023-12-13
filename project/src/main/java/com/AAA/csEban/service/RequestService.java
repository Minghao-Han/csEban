package com.AAA.csEban.service;

import com.AAA.csEban.pojo.AbsentRequest;

import java.util.List;

public interface RequestService {
    public void addAbsentRequest(AbsentRequest absentRequest);
    public List<AbsentRequest> selectAbsentRequestByStuId(int stuId);
}
