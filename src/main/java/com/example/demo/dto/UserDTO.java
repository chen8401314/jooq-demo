package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;


    private String name;
}
