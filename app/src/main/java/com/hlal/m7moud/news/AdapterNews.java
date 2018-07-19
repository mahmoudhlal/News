package com.hlal.m7moud.news;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hlal.m7moud.news.dataproccess.DataEncapsulation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> implements View.OnClickListener {
    List<DataEncapsulation> arrayList ;
    Context context ;
    DataEncapsulation dataEncap = new DataEncapsulation();
    MainActivity mainActivity ;


    public AdapterNews(List<DataEncapsulation> arrayList, Context context , MainActivity mainActivity ) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity = mainActivity ;
    }

    @Override
    public AdapterNews.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items , parent , false) ;
        ViewHolder viewHolder  = new ViewHolder(view);

        return viewHolder ;
    }

    @Override
    public void onBindViewHolder( AdapterNews.ViewHolder holder, int position) {

        dataEncap = arrayList.get(position) ;

        holder.cardView.setTag(position);
        holder.title.setText(dataEncap.getTitle());
        holder.desc.setText(dataEncap.getDesc());

        Picasso.with(context).load(dataEncap.getImg()).into(holder.imageNews);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView ;
        ImageView imageNews ;
        TextView title ;
        TextView desc ;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view.findViewById(R.id.cardview);
            imageNews = (ImageView) view.findViewById(R.id.imageView2);
            title = (TextView) view.findViewById(R.id.title_news);
            desc = (TextView) view.findViewById(R.id.desc_news);
            cardView.setOnClickListener((View.OnClickListener) this);
        }


        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            dataEncap = arrayList.get(position) ;

            Intent intent = new Intent(mainActivity , Main2Activity.class) ;

            intent.putExtra("title" , dataEncap.getTitle());
            intent.putExtra("desc" , dataEncap.getDesc());
            intent.putExtra("image" , dataEncap.getImg());

            mainActivity.startActivity(intent);

        }
    }

}


