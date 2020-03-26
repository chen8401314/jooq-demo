package com.example.demo.dto;

import com.example.demo.enumeration.EventStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TestDTO extends BaseDTO{

    private Integer age;

    private String name;

    private EventStatus eventStatus;
}
