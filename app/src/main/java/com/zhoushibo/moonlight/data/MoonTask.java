package com.zhoushibo.moonlight.data;

import com.geocentric.foundation.net.ApiService;
import com.geocentric.foundation.utils.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * @author shibo
 * @description
 * @date 2017/9/28
 */
public class MoonTask {

    public static ApiService getDefault(final boolean needToken) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okClient = new OkHttpClient
                .Builder()
                .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request.Builder builder = chain.request().newBuilder()
                                .url((chain.request().url().toString()));
                        Request request;
                        request = builder.build();
                        return chain.proceed(request);
                    }
                }).build();
        return new Retrofit.Builder()
                .baseUrl("https://young-dawn-58847.herokuapp.com")
                .addConverterFactory(new com.geocentric.foundation.net.FastJsonConvertFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okClient)
                .build().create(ApiService.class);

    }

    public static ApiService getExternal(String baseUrl) {
        OkHttpClient okClient = new OkHttpClient
                .Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request;
                        request = chain.request().newBuilder().build();
                        LogUtil.defaultLog("request url: " + chain.request().url());
                        return chain.proceed(request);
                    }
                })
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(new com.geocentric.foundation.net.FastJsonConvertFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okClient)
                .build().create(ApiService.class);

    }

}
