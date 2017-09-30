package com.zhoushibo.moonlight.data;

/**
 * @author shibo
 * @description
 * @date 2017/9/28
 */
public abstract class ApiConfig {

    public static String BASE_URL = "";

    public ApiConfig() {
        this.BASE_URL = getBaseUrl();
    }

    abstract String getBaseUrl();
}
