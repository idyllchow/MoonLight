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
    public String title;
    public String title_en;
    public String content;
    public String content_en;
    public String content_dual;
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
        dest.writeString(this.content_dual);
        dest.writeStringList(this.author);
        dest.writeString(this.date);
        dest.writeStringList(this.image_urls);
    }

    public NewContent() {
    }

    protected NewContent(Parcel in) {
        this.title = in.readString();
        this.title_en = in.readString();
        this.content = in.readString();
        this.content_en = in.readString();
        this.content_dual = in.readString();
        this.author = in.createStringArrayList();
        this.date = in.readString();
        this.image_urls = in.createStringArrayList();
    }

    public static final Parcelable.Creator<NewContent> CREATOR = new Parcelable.Creator<NewContent>() {
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
