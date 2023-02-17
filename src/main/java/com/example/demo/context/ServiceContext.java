package com.example.demo.context;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ServiceContext {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHENTICATED_HEADER = "authenticatedUser";
    public static final String TRACE_ID_HEADER = "X-Trace-Id";
    public static final String USER_NAME = "X-User-Name";
    public static final String SERVICE_ID = "X-Service-Id";

}

