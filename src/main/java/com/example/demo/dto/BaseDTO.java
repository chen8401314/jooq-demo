package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDTO implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
