package com.zhoushibo.moonlight.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;


public class ResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    public ResponseConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource buffer = Okio.buffer(value.source());
        String s = buffer.readUtf8();
        buffer.close();
        try {
            return JSON.parseObject(s, type);
        } catch (JSONException e) {
//            return (T) JSON.parseArray(s);
            throw new JSONException("parseObject error", e);
        }
    }
}
