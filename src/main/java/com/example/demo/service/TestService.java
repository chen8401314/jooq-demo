package com.example.demo.service;


import com.example.demo.jooq.tables.daos.TestDao;
import com.example.demo.jooq.tables.pojos.TestEntity;
import com.example.demo.repository.TestRep;
import com.example.demo.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestService {


/*    @Autowired
    TestDao testDao;*/

    @Autowired
    TestRep testRep;

    @Autowired
    TestDao testDao;

    public TestEntity selectById(String id) {
        return testDao.findById(id);
    }

    public void save(TestEntity testEntiy) {
        testEntiy.setId(BaseUtil.getUUID());
        testEntiy.setCreateTime(LocalDateTime.now());
        testDao.insert(testEntiy);
    }

    public void update(TestEntity testEntity) {
        testDao.update(testEntity);
    }


    public void delete(String id) {
        testDao.deleteById(id);
    }

}
