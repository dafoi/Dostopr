package com.example.ghuyo9kli;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenuActivity extends svo {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loading_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    bindButtons();
    }
    public void bindButtons(){
        findViewById(R.id.goAccountButton).setOnClickListener(v->{
                    if(FirebaseAuth.getInstance().getCurrentUser() == null) {
                        startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
                    }else{
                        showDialog();
                    }
                }


        );
        findViewById(R.id.goRussia).setOnClickListener(v-> {
            changeActivity(this,RusisaActivity.class);

        });
        findViewById(R.id.goSpany).setOnClickListener(v-> {
            changeActivity(this,SpanyRazdelActivity.class);
        });

    }
    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы уже вошли в аккаунт!")
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setView(R.layout.dialodg)

              .setPositiveButton((CharSequence) "Подтвердить", (dialog,which) -> {
                  startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
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