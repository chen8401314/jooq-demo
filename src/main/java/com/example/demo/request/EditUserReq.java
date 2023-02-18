package com.example.demo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditUserReq extends UserReq{
    private String id;
}
