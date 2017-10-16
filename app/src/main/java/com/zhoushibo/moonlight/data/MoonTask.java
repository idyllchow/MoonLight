package com.zhoushibo.moonlight.data;

import com.geocentric.foundation.utils.LogUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author shibo
 * @description
 * @date 2017/9/28
 */
public class MoonTask {

    private static final int TIMEOUT_READ = 30;
    private static final int TIMEOUT_WRITE = 30;

    public static MoonApiService getDefault(final boolean needToken) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okClient = new OkHttpClient
                .Builder()
                .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
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
                .baseUrl("https://cryptic-fortress-71485.herokuapp.com")
                .addConverterFactory(new com.geocentric.foundation.net.FastJsonConvertFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okClient)
                .build().create(MoonApiService.class);

    }

    public static MoonApiService getExternal(String baseUrl) {
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okClient)
                .build().create(MoonApiService.class);
    }

}
