package com.example.ghuyo9kli;

import android.content.Intent;
import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class svo extends AppCompatActivity
{
    void changeActivity(Context diz, Class<?> da){
        startActivity(new Intent(diz,da));
        finish();
    }



}
