package com.example.ghuyo9kli;

import android.content.Intent;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class svo extends AppCompatActivity
{
    public Boolean visited = false;
    public String place_name = "";
    public Button but;
    void changeActivity(Context diz, Class<?> da){
        startActivity(new Intent(diz,da));
        //finish();
    }


    public void onEnter(String name){

        place_name = name;
        but = findViewById(R.id.visit);
        but.setOnClickListener(v-> clicked());
//        if(visited){
//            but.setText("Посещено");
//        }else{
//            but.setText("Не посещено");
//        }
        if(Manager.visited_places.contains(place_name)){
            but.setText("Посещено");
        }else{
            but.setText("Не посещено");
        }
    }

    public void clicked(){

        if(!Manager.visited_places.contains(place_name)){
            Manager.addPlace(place_name);
            but.setText("Посещено");

        }else{

            Manager.removePlace(place_name);
            but.setText("Не посещено");
        }

    }


}
