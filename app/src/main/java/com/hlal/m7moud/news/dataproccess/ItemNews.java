package com.hlal.m7moud.news.dataproccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemNews {

    @SerializedName("status")
    @Expose
    private String status ;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults ;
    @SerializedName("articles")
    @Expose
    private List<DataEncapsulation> articles = null  ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<DataEncapsulation> getArticles() {
        return articles;
    }

    public void setArticles(List<DataEncapsulation> articles) {
        this.articles = articles;
    }
}
