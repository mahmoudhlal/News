package com.hlal.m7moud.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hlal.m7moud.news.dataproccess.DataEncapsulation;
import com.hlal.m7moud.news.dataproccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    JsonParser parser ;
    private RecyclerView recyclerView ;
    private AdapterNews adapterNews ;
    final static String api  = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=111f0795b6d845b9ab38a833168c3be4" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Connect connect = new Connect() ;
        try {

            parser = new JsonParser();

            ArrayList<DataEncapsulation> arrayList = parser.Jsonproccess(connect.execute(api).get()) ;

            RecyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void RecyclerMain(){
        recyclerView = (RecyclerView)findViewById(R.id.recycview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()) ;
        recyclerView.setLayoutManager(layoutManager);

        adapterNews = new AdapterNews(parser.getData() , getApplicationContext() , this) ;
        recyclerView.setAdapter(adapterNews);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapterNews.notifyDataSetChanged();
    }
}
