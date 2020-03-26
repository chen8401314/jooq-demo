package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class BaseUtil {
    public static String getUUID() {
        return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }
}
