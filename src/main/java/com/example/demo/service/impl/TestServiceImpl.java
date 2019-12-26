package com.example.demo.service.impl;

import com.example.demo.jooq.tables.TestTable;
import com.example.demo.jooq.tables.daos.TestDao;
import com.example.demo.jooq.tables.pojos.Test;
import com.example.demo.service.TestService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    DSLContext dsl;

    @Autowired
    TestDao testDao;

    TestTable t = TestTable.PF_TEST_T.as("t");

    @Override
    public Test selectById(String id) {
       // Test test = dsl.select().from(t).where(t.ID.eq(id)).fetchOne().into(Test.class);
       Test test = testDao.fetchOneById(id);
        return test;
    }
}
