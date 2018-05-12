package com.hlal.m7moud.news.dataproccess;

public class DataEncapsulation {
    private String url ;
    private String img ;
    private String desc ;
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
