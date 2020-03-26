package com.example.demo.controller;


import com.example.demo.Response;
import com.example.demo.dto.PageTestDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.jooq.tables.pojos.TestEntity;
import com.example.demo.request.TestReq;
import com.example.demo.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.mapstrut.TestMapper.TEST_MAPPER;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenx
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation(value = "根据ID查询Test")
    @GetMapping(value = "/findById")
    public Response<TestDTO> findById(@RequestParam String id) {
        return Response.success(testService.selectById(id));
    }

    @ApiOperation(value = "根据ID查询Test")
    @PostMapping(value = "/save")
    public Response<TestDTO> findById(@RequestBody TestReq testReq) {
        TestEntity testEntity = TEST_MAPPER.toTestEntity(testReq);
        testService.saveOrUpdate(testEntity);
        return Response.success();
    }

    @ApiOperation(value = "根据name查询test分页")
    @GetMapping(value = "/findPageByName")
    public Response<PageTestDTO> findPageByName(@RequestParam(required = false) String name,@RequestParam int page,@RequestParam int size) {
        return Response.success(testService.findPageByName(page,size,name));
    }
}
