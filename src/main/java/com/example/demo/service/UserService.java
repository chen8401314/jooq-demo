package com.example.demo.service;


import com.example.demo.dto.Page;
import com.example.demo.dto.UserDTO;
import com.example.demo.jooq.tables.daos.UserDao;
import com.example.demo.jooq.tables.pojos.UserEntity;
import com.example.demo.repository.UserRep;
import com.example.demo.request.EditUserReq;
import com.example.demo.request.QueryUserReq;
import com.example.demo.request.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.mapstrut.UserMapper.USER_MAPPER;

@Service
public class UserService {

    @Autowired
    UserRep userRep;

    @Autowired
    UserDao userDao;

    public void save(UserReq req) {
        userDao.insert(USER_MAPPER.toEntity(req));
    }

    public UserEntity findById(String id) {
        return userDao.findById(id);
    }

    public void update(UserEntity entity, EditUserReq req) {
        USER_MAPPER.copyProperties(req, entity);
        userDao.update(entity);
    }

    public Page<UserDTO> findPageByName(QueryUserReq req) {
        return userRep.findPageByName(req);
    }

    public void delete(String id) {
        userDao.deleteById(id);
    }

}
