package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryUserReq extends PageReq {

    @ApiModelProperty(value = "名字")
    private String name;
}
