package com.zhoushibo.moonlight.news.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geocentric.foundation.utils.LogUtil;
import com.zhoushibo.moonlight.data.MoonTask;
import com.zhoushibo.moonlight.news.model.NewsBean;
import com.zhoushibo.moonlight.news.view.MoonBaseAdapter;
import com.zhoushibo.moonlight.news.view.NewsAdapter;

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
public class NewsModel extends RecyclerViewViewModel implements Model{

    public final ObservableBoolean dataLoading = new ObservableBoolean(false);
    private final Context mContext;
    public List<NewsBean> list = new ArrayList<>();
//    private BehaviorSubject<ArrayList<NewsBean>> newsSubject = BehaviorSubject.create(new ArrayList<NewsBean>());
//    private BehaviorSubject<Boolean> isLoadingSubject = BehaviorSubject.create(false);
    private NewsAdapter adapter;
    private RecyclerView mRecyclerView;

    public NewsModel(final Context mContext, final RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mRecyclerView = recyclerView;
        adapter = new NewsAdapter(mContext, list);
        mRecyclerView.setLayoutManager(createLayoutManager());
        mRecyclerView.setAdapter(adapter);

        Observable<List<NewsBean>> call = MoonTask.getDefault(false).getNews(1, 10);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NewsBean>>() {
                    @Override
                    public void accept(List<NewsBean> newsBeanList) throws Exception {
                        list.addAll(newsBeanList);
//                        adapter = new NewsAdapter(mContext, newsBeanList);
//                        mRecyclerView.setLayoutManager(createLayoutManager());
//                        mRecyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        LogUtil.defaultLog("newsBeanList size: " + newsBeanList.size() + "; newsModel=====title====" + newsBeanList.get(0).title + "; title en: " + newsBeanList.get(0).title_en);
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

    public void start() {
//        Observable<List<NewsBean>> call = MoonTask.getDefault(false).getNews();
//        call.subscribeOn(Schedulers.io())
//                .flatMap(new Func1<List<NewsBean>, Observable<NewsBean>>() {
//                    @Override
//                    public Observable<NewsBean> call(List<NewsBean> newsBeanList) {
//                        return Observable.from(newsBeanList);
//                    }
//                }).subscribe(new Subscriber<NewsBean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(NewsBean newsBean) {
//
//            }
//        });
    }

//    public Observable<List<NewsBean>> loadMoreNews() {
//        if (isLoadingSubject.getValue()) {
//            return Observable.empty();
//        }
//        isLoadingSubject.onNext(true);
//        return MoonTask.getDefault(false)
//                .getNews()
//                .doOnNext(new )
//
//    }

//    public Observable<ArrayList<NewsBean>> newsObservable() {
//        return newsSubject.asObservable();
//    }
//
//    public Observable<Boolean> isLoadingObservable() {
//        return isLoadingSubject.asObservable();
//    }

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
