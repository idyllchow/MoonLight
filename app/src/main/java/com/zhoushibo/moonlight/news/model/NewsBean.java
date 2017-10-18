package com.zhoushibo.moonlight.news.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/10/10
 */
public class NewsBean implements Parcelable {
    public int index;
    public int total_num;
    public List<NewContent> news;

    public NewsBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.index);
        dest.writeInt(this.total_num);
        dest.writeTypedList(this.news);
    }

    protected NewsBean(Parcel in) {
        this.index = in.readInt();
        this.total_num = in.readInt();
        this.news = in.createTypedArrayList(NewContent.CREATOR);
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel source) {
            return new NewsBean(source);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };
}
