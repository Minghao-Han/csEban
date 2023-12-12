package com.AAA.csEban.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Notice {
    private int noticeId;
    private String teacherId;
    private String content;
}
