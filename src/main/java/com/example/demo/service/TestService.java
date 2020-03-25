package com.example.demo.service;


import com.example.demo.jooq.tables.pojos.TestPOJO;

public interface TestService {

    /** 查询单个*/
    public TestPOJO selectById(String id);
}
