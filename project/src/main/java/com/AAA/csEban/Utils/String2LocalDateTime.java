package com.AAA.csEban.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class String2LocalDateTime {
    public static String DEFAULT_PATTERN = "yyyy/MM/dd HH:mm";
    public static LocalDateTime transform(String dateTimeString,String pattern) {
        try {
            // 创建 DateTimeFormatter 格式化器
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            // 将字符串解析为 LocalDateTime 对象
            return LocalDateTime.parse(dateTimeString, formatter);
        }catch (Exception e){
            System.out.println("pattern error or not mismatch "+e.toString());
            return null;
        }
    }
    public static LocalDateTime transform(String dateTimeString) {
        try {
            // 创建 DateTimeFormatter 格式化器
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
            // 将字符串解析为 LocalDateTime 对象
            return LocalDateTime.parse(dateTimeString, formatter);
        }catch (Exception e){
            System.out.println("pattern error or not mismatch "+e.toString());
            return null;
        }
    }
}

