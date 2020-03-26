package com.example.demo.request;

import com.example.demo.enumeration.EventStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestReq {

    private String id;
    private Integer age;
    private LocalDate birthday;
    private String name;
    private String sex;
    private String department;
    private String homeAddress;
    private EventStatus eventStatus;
    private Boolean isMarry;
}
