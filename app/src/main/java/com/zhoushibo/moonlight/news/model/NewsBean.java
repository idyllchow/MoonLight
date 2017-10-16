package com.zhoushibo.moonlight.news.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.geocentric.foundation.net.BaseBean;

import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/10/10
 */
public class NewsBean extends BaseBean implements Parcelable {
    public String title;
    public String title_en;
    public String content;
    public String content_en;
    public List<String> author;
    public String date;
    public List<String> image_urls;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.title_en);
        dest.writeString(this.content);
        dest.writeString(this.content_en);
        dest.writeStringList(this.author);
        dest.writeString(this.date);
        dest.writeStringList(this.image_urls);
    }

    public NewsBean() {
    }

    protected NewsBean(Parcel in) {
        this.title = in.readString();
        this.title_en = in.readString();
        this.content = in.readString();
        this.content_en = in.readString();
        this.author = in.createStringArrayList();
        this.date = in.readString();
        this.image_urls = in.createStringArrayList();
    }

    public static final Parcelable.Creator<NewsBean> CREATOR = new Parcelable.Creator<NewsBean>() {
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
