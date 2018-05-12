package com.hlal.m7moud.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    TextView title , desc ;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = (TextView)findViewById(R.id.txtTitle) ;
        desc = (TextView)findViewById(R.id.txtdesc) ;
        imageView = (ImageView)findViewById(R.id.imgshow) ;

        Intent intent = this.getIntent() ;

        title.setText(intent.getStringExtra("title"));
        desc.setText(intent.getStringExtra("desc"));
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("image")).into(imageView);
    }

    public void buBack(View view) {
        Intent i = new Intent(this , MainActivity.class);
        startActivity(i);
    }
}
