package com.example.ghuyo9kli;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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


public class RegisterActivity extends svo {
    EditText editEmail, editPassword, editPassword2;
    ImageButton  registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //FirebaseAuth.getInstance().createUserWithEmailAndPassword("vasekvovabob@gmail.com" , "passworasd");
        connectButtons();
    }
    public void gotoLogin(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    public void register(){
        //if empty
        if(editEmail.getText().toString().isEmpty() || editPassword.getText().toString().isEmpty() || editPassword2.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this, " Не все поля заполнены", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editPassword.getText().toString().length() < 6){
            Toast.makeText(RegisterActivity.this,"Пароль должен быть больше 5 символов", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!editPassword.getText().toString().equals(editPassword2.getText().toString())) {
            Toast.makeText(RegisterActivity.this,
                    "Пароли должны совпадать",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(editEmail.getText().toString(),editPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Готово!", Toast.LENGTH_SHORT).show();
                            goNext();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Такой пользователь существует", Toast.LENGTH_SHORT).show();
                        }
                    }
               });



    }
    public void connectButtons(){
        //References
        editEmail = findViewById(R.id.editEmailRegister);
        editPassword = findViewById(R.id.editPasswordRegister);
        editPassword2 = findViewById(R.id.editPasswordRegister2);
        findViewById(R.id.gotoLoginButton).setOnClickListener(v -> gotoLogin());
        registerButton = findViewById(R.id.bombaclat);
        findViewById(R.id.nazadFromRegister).setOnClickListener(v-> goBack());
        //Events

        registerButton.setOnClickListener(v -> register());
    }
    //Not implemented yet, should take you to main menu
    public void goNext(){
        changeActivity(this, LoadingActivity.class);
    }
    public void goBack(){
//        startActivity(new Intent(RegisterActivity.this,LoadingActivity.class));
//        finish();
        changeActivity(this, LoadingActivity.class);
    }
}