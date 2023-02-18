
package com.example.demo.repository;

import com.example.demo.jooq.tables.TestTable;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRep {


    @Autowired
    DSLContext dsl;
    TestTable t = TestTable.PF_TEST_T.as("t");


}

