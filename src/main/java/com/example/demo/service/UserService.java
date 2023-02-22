package com.example.demo.service;


import com.example.demo.dto.Page;
import com.example.demo.dto.UserDTO;
import com.example.demo.jooq.tables.daos.UserDao;
import com.example.demo.jooq.tables.pojos.UserEntity;
import com.example.demo.jooq.tables.records.UserRecord;
import com.example.demo.repository.UserRep;
import com.example.demo.request.QueryUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserDao, UserEntity, UserRecord> {

    @Autowired
    UserRep userRep;

    public Page<UserDTO> findPageByName(QueryUserReq req) {
        return userRep.findPageByName(req);
    }


}
