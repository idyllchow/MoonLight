package com.zhoushibo.moonlight.data;

import com.geocentric.foundation.net.BaseBean;
import com.zhoushibo.moonlight.news.model.NewsBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public interface MoonApiService  {

    //获取新闻
    @GET("/news")
    Observable<List<NewsBean>> getNews(@Query("index") int index, @Query("count") int count);

    //获取新闻概览
    @GET("/news/summary")
    Observable<BaseBean> getNewsSummary();

    //获取新闻标题
    @GET("/news/title")
    Observable<BaseBean> getNewsTitle();

}
