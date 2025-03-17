package com.example.ghuyo9kli;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RusisaActivity extends svo {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rusisa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.gyym).setOnClickListener(v -> changeActivity(this,GymActivity.class));
        findViewById(R.id.bolshoiteatr).setOnClickListener(v -> changeActivity(this, bolshoiteatrActivity.class));
        findViewById(R.id.jermitaj).setOnClickListener(v -> changeActivity(this, JermitajActivity.class));
        findViewById(R.id.spas).setOnClickListener(v -> changeActivity(this, HramSpasNaKroviActivity.class));
        findViewById(R.id.trgalereia).setOnClickListener(v -> changeActivity(this, TretgalerActivity.class));
        findViewById(R.id.vdnh).setOnClickListener(v -> changeActivity(this,VdnhActivity.class));



    }
}