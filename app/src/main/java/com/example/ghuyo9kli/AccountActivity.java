package com.example.ghuyo9kli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class AccountActivity extends svo {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.account_quit).setOnClickListener(v->showDialog());
        findViewById(R.id._nazad3).setOnClickListener(v->changeActivity(this,MainMenuActivity.class));
        findViewById(R.id.clearButton).setOnClickListener(v-> {
            Manager.visited_places.clear();
            update();
        });
        update();

    }

    public void update(){
        TextView email_text = findViewById(R.id.account_email_text);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if(user != null){
            if(user.getEmail() != null){
                email_text.setText(user.getEmail());
            }
        }






        text = findViewById(R.id.visited_places);
        String txt = "";
        for (String place : Manager.visited_places
        ) {
            txt = txt.concat(place + "\n");
        }
        text.setText(txt);
        }
    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выйти из аккаунта?")
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setView(R.layout.dialodg)

                .setPositiveButton((CharSequence) "Подтвердить", (dialog,which) -> {
                    startActivity(new Intent(this, LoginActivity.class));
                    FirebaseAuth.getInstance().signOut();
                })


//                    startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
//                })
                .setNegativeButton("Отмена", null)
                .create();

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}