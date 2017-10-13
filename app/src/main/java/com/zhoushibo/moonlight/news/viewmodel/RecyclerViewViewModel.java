package com.zhoushibo.moonlight.news.viewmodel;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;

import com.zhoushibo.moonlight.news.view.MoonBaseAdapter;

/**
 * @author shibo
 * @description
 * @date 2017/10/12
 */
public abstract class RecyclerViewViewModel implements Model {

    RecyclerView.LayoutManager layoutManager;
    private Parcelable savedLayoutManagerState;

    protected abstract MoonBaseAdapter getAdapter();
    protected abstract RecyclerView.LayoutManager createLayoutManager();

    public final void setupRecyclerView(RecyclerView recyclerView) {
        layoutManager = createLayoutManager();
        if (savedLayoutManagerState != null) {
            layoutManager.onRestoreInstanceState(savedLayoutManagerState);
            savedLayoutManagerState = null;
        }
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(layoutManager);
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
