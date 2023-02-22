package com.example.demo.controller;


import com.example.demo.Response;
import com.example.demo.dto.Page;
import com.example.demo.dto.TestDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.jooq.tables.pojos.UserEntity;
import com.example.demo.request.EditUserReq;
import com.example.demo.request.QueryUserReq;
import com.example.demo.request.UserReq;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.mapstrut.UserMapper.USER_MAPPER;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenx
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据ID查询Test")
    @GetMapping(value = "/findById")
    public Response<UserDTO> findById(@RequestParam String id) {
        return Response.success(USER_MAPPER.toDTO(userService.findById(id)));
    }

    @ApiOperation(value = "保存")
    @PostMapping(value = "/save")
    public Response<Void> save(@RequestBody UserReq req) {
        userService.save(USER_MAPPER.toEntity(req));
        return Response.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping(value = "/update")
    public Response<Void> update(@RequestBody EditUserReq req) {
        UserEntity entity = userService.findById(req.getId());
        if (entity == null) {
            return Response.failure("找不到该数据！");
        }
        USER_MAPPER.copyProperties(req, entity);
        userService.update(entity);
        return Response.success();
    }

    @ApiOperation(value = "根据name查询分页")
    @PostMapping(value = "/findPage")
    public Response<Page<UserDTO>> findPageByName(@RequestBody QueryUserReq req) {
        return Response.success(userService.findPageByName(req));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/deleteById")
    public Response<TestDTO> delete(@RequestParam String id) {
        userService.deleteById(id);
        return Response.success();
    }
}
