package com.zhoushibo.moonlight.news;

import android.content.Context;

import com.zhoushibo.moonlight.R;

import java.util.ArrayList;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public class NewsAdapter extends SingleLayoutAdapter {

    private Context mContext;

    private ArrayList<TitleBean> list = new ArrayList<>();

    public NewsAdapter(Context context, ArrayList<TitleBean> list) {
        super(R.layout.item_news);
        this.mContext = context;
        this.list = list;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
