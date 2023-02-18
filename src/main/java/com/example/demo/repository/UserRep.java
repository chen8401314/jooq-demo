
package com.example.demo.repository;

import com.example.demo.dto.Page;
import com.example.demo.dto.UserDTO;
import com.example.demo.jooq.tables.UserTable;
import com.example.demo.request.QueryUserReq;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRep {


    @Autowired
    DSLContext dsl;

    @Autowired
    BaseRep baseRep;

    UserTable user = UserTable.PF_USER_T.as("user");

    public Page<UserDTO> findPageByName(QueryUserReq req) {
        Condition condition = user.NAME.like("%" + req.getName() + "%");
        return baseRep.page(UserDTO.class, user, user.fields(), condition, List.of(user.CREATED_DT.desc()), req);
    }


}

