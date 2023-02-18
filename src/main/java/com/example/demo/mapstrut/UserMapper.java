package com.example.demo.mapstrut;

import com.example.demo.config.InsertFill;
import com.example.demo.config.StructConfig;
import com.example.demo.dto.TestDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.jooq.tables.pojos.TestEntity;
import com.example.demo.jooq.tables.pojos.UserEntity;
import com.example.demo.request.EditUserReq;
import com.example.demo.request.TestReq;
import com.example.demo.request.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = StructConfig.class)
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @InsertFill
    UserEntity toEntity(UserReq req);

    UserDTO toDTO(UserEntity entity);

    void copyProperties(EditUserReq req, @MappingTarget UserEntity userEntity);
}
