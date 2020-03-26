package com.example.demo.service;


import com.example.demo.dto.PageTestDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.jooq.tables.daos.TestDao;
import com.example.demo.jooq.tables.pojos.TestEntity;
import com.example.demo.repository.TestRep;
import com.example.demo.util.BaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TestService {


    @Autowired
    TestDao testDao;

    @Autowired
    TestRep testRep;

    public TestDTO selectById(String id) {
        //TestEntity test = testRep.findById(id);
        //return TEST_MAPPER.toTestDTO(test);
        return testRep.findById(id);
    }

    public void saveOrUpdate(TestEntity testEntiy) {
        if (StringUtils.isEmpty(testEntiy.getId())) {
            testEntiy.setId(BaseUtil.getUUID());
            testEntiy.setCreateTime(LocalDateTime.now());
        }
        testDao.insert(testEntiy);
    }

    public PageTestDTO findPageByName(int page, int size, String name) {
        return testRep.findPageByName(name, page, size);
    }


}
