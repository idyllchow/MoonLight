package com.zhoushibo.moonlight.news.model;

import com.geocentric.foundation.net.BaseBean;

import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/10/10
 */
public class NewsBean extends BaseBean {
    public String title;
    public String title_en;
    public String content;
    public String content_en;
    public List<String> author;
    public String date;
    public List<String> image_urls;

}
