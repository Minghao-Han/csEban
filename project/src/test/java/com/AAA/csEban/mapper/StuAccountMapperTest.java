package com.AAA.csEban.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StuAccountMapperTest {
    @Autowired
    private StuAccountMapper stuAccountMapper;

    @Test
    void selectAccountById() {
        System.out.println(stuAccountMapper.selectAccountById(1));
    }
}