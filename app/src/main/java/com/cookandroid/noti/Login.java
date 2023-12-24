package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login extends AppCompatActivity {
    ImageButton loginButton;
    EditText id,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.roginButton);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);

        Intent intent = new Intent(this, EventChoiceActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() { //로그인 버튼 클릭시
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }
}