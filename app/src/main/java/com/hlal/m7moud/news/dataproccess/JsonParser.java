package com.hlal.m7moud.news.dataproccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    ArrayList<DataEncapsulation> data ;

    public ArrayList<DataEncapsulation> Jsonproccess(String jsonfile){

        data = new ArrayList<>() ;
        try {
            JSONObject mainjson = new JSONObject(jsonfile) ;
            JSONArray jsonArray = mainjson.getJSONArray("articles");

            for(int i = 0 ; i<jsonArray.length() ; i++){
                JSONObject mainObjectarray = jsonArray.getJSONObject(i) ;

                DataEncapsulation dataEncap = new DataEncapsulation(mainObjectarray.getString(KeyTags.urlkey)
                                              , mainObjectarray.getString(KeyTags.imgkey) ,
                                                mainObjectarray.getString(KeyTags.desckey) ,
                                                mainObjectarray.getString(KeyTags.titlekey));

                data.add(dataEncap) ;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data ;

    }

    public ArrayList<DataEncapsulation> getData() {
        return data;
    }
}
