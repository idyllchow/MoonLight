package com.zhoushibo.moonlight.news.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/10/17
 */
public class NewContent implements Parcelable {
    public String title_cn;
    public String title_en;
    public String content_cn;
    public String content_en;
    public String content_dual;
    public List<String> author;
    public String date_cn;
    public String date_en;
    public List<String> image_urls;

    public NewContent() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title_cn);
        dest.writeString(this.title_en);
        dest.writeString(this.content_cn);
        dest.writeString(this.content_en);
        dest.writeString(this.content_dual);
        dest.writeStringList(this.author);
        dest.writeString(this.date_cn);
        dest.writeString(this.date_en);
        dest.writeStringList(this.image_urls);
    }

    protected NewContent(Parcel in) {
        this.title_cn = in.readString();
        this.title_en = in.readString();
        this.content_cn = in.readString();
        this.content_en = in.readString();
        this.content_dual = in.readString();
        this.author = in.createStringArrayList();
        this.date_cn = in.readString();
        this.date_en = in.readString();
        this.image_urls = in.createStringArrayList();
    }

    public static final Creator<NewContent> CREATOR = new Creator<NewContent>() {
        @Override
        public NewContent createFromParcel(Parcel source) {
            return new NewContent(source);
        }

        @Override
        public NewContent[] newArray(int size) {
            return new NewContent[size];
        }
    };
}
