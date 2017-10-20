package com.zhoushibo.moonlight.news.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geocentric.foundation.utils.CommUtil;
import com.geocentric.foundation.utils.FileUtil;
import com.geocentric.foundation.utils.LogUtil;
import com.zhoushibo.moonlight.data.MoonTask;
import com.zhoushibo.moonlight.news.model.NewContent;
import com.zhoushibo.moonlight.news.model.NewsBean;
import com.zhoushibo.moonlight.news.view.MoonBaseAdapter;
import com.zhoushibo.moonlight.news.view.NewsAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author shibo
 * @description
 * @date 2017/9/28
 */
public class NewsModel extends RecyclerViewViewModel implements Model {

    public final ObservableBoolean dataLoading = new ObservableBoolean(false);
    private final Context mContext;
    public List<NewContent> list = new ArrayList<>();
    //    private BehaviorSubject<ArrayList<NewsBean>> newsSubject = BehaviorSubject.create(new ArrayList<NewsBean>());
//    private BehaviorSubject<Boolean> isLoadingSubject = BehaviorSubject.create(false);
    private NewsAdapter adapter;
    private RecyclerView mRecyclerView;
    private int index = 0;
    private final int COUNT = 6;
    private int totalCount;
    private DiskLruCache cache;


    public NewsModel(final Context mContext, final RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mRecyclerView = recyclerView;
        adapter = new NewsAdapter(mContext, list);
        mRecyclerView.setLayoutManager(createLayoutManager());
        mRecyclerView.setAdapter(adapter);
        loadCache();
        getNews(true);
    }

    public void getNews(final boolean isRefresh) {
        if (isRefresh) {
            index = 0;
        }
        Observable<NewsBean> call = MoonTask.getDefault(false).getNews(index, COUNT);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsBean>() {
                    @Override
                    public void accept(NewsBean newsBean) throws Exception {
                        if (isRefresh) {
                            list.clear();
                        }
                        list.addAll(newsBean.news);
                        adapter.notifyDataSetChanged();
                        index = newsBean.index + 1;
                        totalCount = newsBean.total_num;
                    }
                });

    }

    @Override
    protected MoonBaseAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    private void loadCache() {
        List<NewContent> cacheData = (List<NewContent>) cache.getListFromMemCache("news");
        LogUtil.defaultLog("cache data " + cacheData);

        File diskCacheDir = getDiskCacheDir(mContext, "diskcache");

        try {


            cache = DiskLruCache.open(diskCacheDir, 1, 1, 10 * 1024 * 1024);
        } catch (IOException e) {

        }

        if (cacheData != null) {
            list.addAll(cacheData);
            adapter.notifyDataSetChanged();
        }
    }

    public File getDiskCacheDir(Context context, String filePath) {
        boolean externalStorageAvailable = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        final String cachePath;
        if (externalStorageAvailable) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + filePath);
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
