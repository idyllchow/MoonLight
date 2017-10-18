package com.zhoushibo.moonlight.news.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhoushibo.moonlight.BaseFragment;
import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.databinding.FragNewsBinding;
import com.zhoushibo.moonlight.news.viewmodel.NewsModel;


/**
 * @author shibo
 * @description
 * @date 2017/9/26
 */
public class NewsFragment extends BaseFragment {

    private FragNewsBinding binding;
    private NewsModel newsModel;
    /** Hold active loading observable subscriptions, so that they can be unsubscribed from when the activity is destroyed */
//    private CompositeSubscription subscriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_news, container, false);
        binding.setView(this);
        rootView = binding.getRoot();
//        subscriptions = new CompositeSubscription();
        newsModel = new NewsModel(getContext(), binding.newsList);
        loadData();
        newsModel.onCreate();
        return rootView;
    }

    private void loadNextPage() {
//        subscriptions.add(newsModel);
    }

    private void initBinding() {
        // Observable that emits when the RecyclerView is scrolled to the bottom
//        Observable<Void> infiniteScrollObservable = Observable.create(new Observable.OnSubscribe<Void>() {
//        });
        // Observable that emits when the RecyclerView is scrolled to the bottom
//        Observable<Void> infiniteScrollObservable = Observable.create(new Observable.OnSubscribe<Void>() {
//            @Override
//            public void call(final Subscriber<? super Void> subscriber) {
//                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                    @Override
//                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                        int totalItemCount = layoutManager.getItemCount();
//                        int visibleItemCount = layoutManager.getChildCount();
//                        int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
//
//                        if ((visibleItemCount + firstVisibleItem) >= totalItemCount)
//                        {
//                            subscriber.onNext(null);
//                        }
//                    }
//                });
//            }
//        });

//        subscriptions.add(
//                // Bind list of posts to the RecyclerView
//                newsModel.newsObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ArrayList<NewsBean>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(ArrayList<NewsBean> newsBeen) {
//
//                    }
//                }),
//
//                // Bind loading status to show/hide loading spinner
////                viewModel.isLoadingObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(getActivity()::setIsLoading),
//
//                // Trigger next page load when RecyclerView is scrolled to the bottom
//                infiniteScrollObservable.subscribe(new Observer<Void>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Void aVoid) {
//
//                    }
//                })
//        );
    }

    private void loadData() {
//        Observable<List<NewsBean>> call = MoonTask.getDefault(false).getNews();
//        call.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<NewsBean>>() {
//                    @Override
//                    public void accept(List<NewsBean> newsBeanList) throws Exception {
//                        adapter = new NewsAdapter(getActivity(), list);
//                        recyclerView.setAdapter(adapter);
//                        LogUtil.defaultLog("=====title====" + newsBeanList.get(0).title + "; title en: " + newsBeanList.get(0).title_en);
//                    }
//                });
//        call.subscribeOn(Schedulers.io())
//                .flatMap(new Func1<List<NewsBean>, Observable<NewsBean>>() {
//                    @Override
//                    public Observable<NewsBean> call(List<NewsBean> newsBeanList) {
//                        adapter = new NewsAdapter(getActivity(), newsBeanList);
//                        recyclerView.setAdapter(adapter);
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
//                LogUtil.defaultLog("=====title====" + newsBean.title + "; title en: " + newsBean.title_en);
//            }
//        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        subscriptions.unsubscribe();
        newsModel.onDestroy();
    }
}
