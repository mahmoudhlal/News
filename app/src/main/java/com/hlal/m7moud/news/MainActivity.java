package com.hlal.m7moud.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hlal.m7moud.news.Remote.ApiUtlis;
import com.hlal.m7moud.news.Remote.UserService;
import com.hlal.m7moud.news.dataproccess.DataEncapsulation;
import com.hlal.m7moud.news.dataproccess.ItemNews;
import com.hlal.m7moud.news.dataproccess.JsonParser;
import com.hlal.m7moud.news.dataproccess.KeyTags;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //JsonParser parser ;
    private RecyclerView recyclerView ;
    private AdapterNews adapterNews ;
    MainActivity mainActivity = this  ;
    //final static String api  = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=111f0795b6d845b9ab38a833168c3be4" ;

    //DataEncapsulation dataEncap ;
    private UserService userService ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        /*Connect connect = new Connect() ;
        try {

            parser = new JsonParser();

            ArrayList<DataEncapsulation> arrayList = parser.Jsonproccess(connect.execute(api).get()) ;

            RecyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


        initComponents() ;

        getNews("us" , "business","111f0795b6d845b9ab38a833168c3be4") ;






    }

    private void initComponents() {
        userService = ApiUtlis.getUserService() ;
    }


    private void getNews(String country , String category , String apiKey){
        Call<ItemNews> call = userService.getnews(country , category , apiKey)  ;
        call.enqueue(new Callback<ItemNews>() {
            @Override
            public void onResponse(Call<ItemNews> call, Response<ItemNews> response) {
                if(response.isSuccessful()) {

                    //List<DataEncapsulation> news = response.body() ;
                    recyclerView = (RecyclerView)findViewById(R.id.recycview);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()) ;
                    recyclerView.setLayoutManager(layoutManager);

                    adapterNews = new AdapterNews(response.body().getArticles(), getApplicationContext() , mainActivity) ;
                    // adapterNews = new AdapterNews(arrayList , getApplicationContext() , this) ;
                    recyclerView.setAdapter(adapterNews);
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                    adapterNews.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<ItemNews> call, Throwable t) {
               // Log.d("errorrrrrrrrrrrrrrr" , t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }


        });
    }



    private void RecyclerMain(){

       /* dataEncap = new DataEncapsulation("koko"
                , "lolo" ,
                "popo" ,
                "soso");

        ArrayList<DataEncapsulation> arrayList = new ArrayList<>();
        arrayList.add(dataEncap);
        */
        recyclerView = (RecyclerView)findViewById(R.id.recycview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()) ;
        recyclerView.setLayoutManager(layoutManager);

       // adapterNews = new AdapterNews(parser.getData() , getApplicationContext() , this) ;
       // adapterNews = new AdapterNews(arrayList , getApplicationContext() , this) ;
        recyclerView.setAdapter(adapterNews);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapterNews.notifyDataSetChanged();
    }
}
