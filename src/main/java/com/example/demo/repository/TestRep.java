
package com.example.demo.repository;

import com.example.demo.dto.PageTestDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.jooq.tables.TestTable;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRep {


    @Autowired
    DSLContext dsl;

    TestTable t = TestTable.PF_TEST_T.as("t");

    public TestDTO findById(String id){
       TestDTO test = dsl.select().from(t).where(t.ID.eq(id)).fetchOneInto(TestDTO.class);
       return test;
    }

    public PageTestDTO findPageByName(String name,int page ,int size){
        SelectJoinStep<?> selectCount = dsl.select(DSL.countDistinct(t.ID)).from(t);
        SelectJoinStep<?> selectData = dsl.selectDistinct(t.fields()).from(t);
        Condition condition =DSL.condition(true);
        if (StringUtils.isNotEmpty(name)) {
            condition = condition.and(t.NAME.like("%" + name + "%"));
        }
        Long count = selectCount.where(condition).fetchOne().into(Long.class);
        List<TestDTO> results = selectData.where(condition).orderBy(t.CREATE_TIME.desc()).limit(size).offset(size * (page - 1)).fetchInto(TestDTO.class);
        return new PageTestDTO(page, size, count, results);
    }

}

