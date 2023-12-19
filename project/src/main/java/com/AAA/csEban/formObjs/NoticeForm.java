package com.AAA.csEban.formObjs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeForm {
    int notice_id;
    String content;
    String poster;//发布人的名字
}
