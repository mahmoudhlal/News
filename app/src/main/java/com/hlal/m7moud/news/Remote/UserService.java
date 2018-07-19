package com.hlal.m7moud.news.Remote;

import com.hlal.m7moud.news.dataproccess.DataEncapsulation;
import com.hlal.m7moud.news.dataproccess.ItemNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {


    @POST("top-headlines")
    Call<ItemNews> getnews(@Query("country")String country
            , @Query("category")String category , @Query("apiKey")String apiKey );
}
