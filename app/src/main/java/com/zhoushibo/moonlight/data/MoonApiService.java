package com.zhoushibo.moonlight.data;

import com.geocentric.foundation.net.ApiService;
import com.geocentric.foundation.net.BaseBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public interface MoonApiService extends ApiService {

    //获取新闻概览
    @GET("/news/summary")
    Observable<BaseBean> getNewsSummary();

    //获取新闻标题
    @GET("/news/title")
    Observable<BaseBean> getNewsTitle();

}
