package com.example.demo.config;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", expression = "java(com.example.demo.util.BaseUtil.getUUID())")
@Mapping(target = "createdDt", expression = "java(java.time.LocalDateTime.now())")
public @interface InsertFill {
}
