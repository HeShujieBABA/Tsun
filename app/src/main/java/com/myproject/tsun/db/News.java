package com.myproject.tsun.db;

/**
 * Created by 何书杰 on 2017/10/31.
 */

public class News {
    private String newsFrom;
    private String newsTime;
    private int imageId;
    private  String newsContent;
    public News(int imageId,String newsContent,String newsFrom,String newsTime){
        this.imageId = imageId;
        this.newsContent = newsContent;
        this.newsFrom = newsFrom;
        this.newsTime = newsTime;
    }
    public int getImageId() {
        return imageId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public String getNewsTime() {
        return newsTime;
    }
}
