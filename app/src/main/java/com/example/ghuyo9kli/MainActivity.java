package com.example.ghuyo9kli;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends svo {

    public static String[] visited_places = {"лмао", "амог"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // Переход на MainActivity
                changeActivity(MainActivity.this, MainMenuActivity.class);
                //changeActivity(MainActivity.this, AccountActivity.class);
            }
        }, 3000); // Задержка 3 секунды


    }
}