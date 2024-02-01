package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    ImageButton loginButton;
    EditText id,password;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.roginButton);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        db = new DBHelper(this);
        Intent intent = new Intent(this, EventChoiceActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() { //로그인 버튼 클릭시
            @Override
            public void onClick(View view) {
                String db_id = db.getUserID(id.getText().toString());
                String db_pw = db.getUserPW(id.getText().toString());

                if(db_id != null && db_pw != null && db_id.equals(id.getText().toString()) && db_pw.equals(password.getText().toString())){
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"아이디나 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}