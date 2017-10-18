package com.zhoushibo.moonlight.news.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.databinding.ItemNewsBinding;
import com.zhoushibo.moonlight.news.model.NewContent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public class NewsAdapter extends MoonBaseAdapter {

    private Context mContext;

    private List<NewContent> list = new ArrayList<>();

    public NewsAdapter(Context context, List<NewContent> list) {
        super(context, R.layout.item_news);
        this.mContext = context;
        this.list = list;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return position;
    }

    @Override
    public MoonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemNewsBinding binding = ItemNewsBinding.inflate(layoutInflater, parent, false);
        return new MoonViewHolder(binding);
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
