package com.AAA.csEban.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public abstract class Request {
    protected int requestId;
    protected Teacher teacher;//负责审核的老师，一般是学生学院的导师
    protected Student student;//发起请求的学生
    protected String information;
    protected boolean isAgree;
    protected String refuseInformation;
    protected RequeseType type;
}
