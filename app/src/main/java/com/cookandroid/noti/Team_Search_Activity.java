package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Team_Search_Activity extends AppCompatActivity {
    ImageButton completeButton, backButton;
    TextView sports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search);

        completeButton = findViewById(R.id.completeButton);
        backButton = findViewById(R.id.backButton);
        sports = findViewById(R.id.sports);

        Intent intent = getIntent();
        sports.setText(intent.getStringExtra("sports"));

        //완료 버튼 클릭시
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Team_Search_Activity.this, MainActivity.class);  //메인화면으로
                startActivity(intent);
            }
        });

        //뒤로가기 버튼 클릭시
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}