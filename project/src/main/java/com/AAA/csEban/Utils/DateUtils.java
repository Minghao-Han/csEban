package com.AAA.csEban.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String DEFAULT_PATTERN = "yyyy/MM/dd HH:mm";
    public static LocalDateTime String2LocalDateTime(String dateTimeString, String pattern) {
        if (dateTimeString==null) return null;
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
    public static LocalDateTime String2LocalDateTime(String dateTimeString) {
        if (dateTimeString==null) return null;
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
    public static String LocalDateTime2String(LocalDateTime localDateTime,String pattern){
        if (localDateTime==null) return "";
        try {
            // 创建 DateTimeFormatter 格式化器
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            // 将字符串解析为 LocalDateTime 对象
            return localDateTime.format(formatter);
        }catch (Exception e){
            System.out.println("pattern error or not mismatch "+e.toString());
            return null;
        }
    }
    public static String LocalDateTime2String(LocalDateTime localDateTime){
        if (localDateTime==null) return "";
        try {
            // 创建 DateTimeFormatter 格式化器
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
            // 将字符串解析为 LocalDateTime 对象
            return localDateTime.format(formatter);
        }catch (Exception e){
            System.out.println("pattern error or not mismatch "+e.toString());
            return null;
        }
    }
}

