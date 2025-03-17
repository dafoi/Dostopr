package com.example.ghuyo9kli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    EditText LogIn_email, LogIn_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //goNext();
        }
        LogIn_email = findViewById(R.id.editEmail);
        LogIn_password = findViewById(R.id.editPassword);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //проверка поля на пустоту, а также пароль чтобы он был не короче 6 символов:

                if(LogIn_email.getText().toString().isEmpty()||
                        LogIn_email.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this,
                            "Не все поля заполнены",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(LogIn_password.getText().toString().length() < 6){
                    Toast.makeText(LoginActivity.this,
                            "Пароль должен состовлять не менее 6 символов",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                //попытка войти в бд

                mAuth.signInWithEmailAndPassword(LogIn_email.getText().toString(),
                        LogIn_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   // @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Готово!",Toast.LENGTH_SHORT).show();
                            goNext();
                        }else {
                            Toast.makeText(LoginActivity.this, "Такого пользователя не сущесвует",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        findViewById(R.id.registerButton).setOnClickListener(v -> goRegister());
        findViewById(R.id.nazad).setOnClickListener(v -> goBack());
    }

    public void goNext(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
    public void goRegister(){
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }public void goBack(){
        startActivity(new Intent(LoginActivity.this,LoadingActivity.class));
        finish();
    }

}