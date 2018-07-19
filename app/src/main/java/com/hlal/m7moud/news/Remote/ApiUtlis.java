package com.hlal.m7moud.news.Remote;

public class ApiUtlis {
    //public static final String Base_Url="http://52.224.66.22/abdullah/hint/hint/public/";
    public static final String Base_Url="https://newsapi.org/v2/";

    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }
}
