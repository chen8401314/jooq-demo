package com.example.demo.controller;


import com.example.demo.Response;
import com.example.demo.jooq.tables.pojos.Test;
import com.example.demo.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping(value = "/findById")
    public Response<Test> findById(@RequestParam String id) {
        return Response.success(testService.selectById(id));
    }
}
