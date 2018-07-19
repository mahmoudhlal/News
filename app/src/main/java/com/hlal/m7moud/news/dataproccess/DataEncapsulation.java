package com.hlal.m7moud.news.dataproccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataEncapsulation {
    @SerializedName("url")
    @Expose
    private String url ;
    @SerializedName("img")
    @Expose
    private String img ;
    @SerializedName("desc")
    @Expose
    private String desc ;
    @SerializedName("title")
    @Expose
    private String title ;

    public DataEncapsulation(String url, String img, String desc, String title) {
        this.url = url;
        this.img = img;
        this.desc = desc;
        this.title = title;
    }

    public DataEncapsulation(){

    }


    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}
