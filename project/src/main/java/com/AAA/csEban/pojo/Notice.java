package com.AAA.csEban.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Notice {
    private int noticeId;
    private Teacher teacher;
    private String content;
}
