package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EventChoiceActivity extends AppCompatActivity {
    ImageButton nextButton, backButton;
    Button baseball, soccer, volleyball, basketball;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_choice);

        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        baseball = findViewById(R.id.baseballButton);
        soccer = findViewById(R.id.soccerButton);
        volleyball = findViewById(R.id.volleyballButton);
        basketball = findViewById(R.id.basketballButton);

        Button.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 색 초기화
                baseball.setBackgroundColor(Color.WHITE);
                soccer.setBackgroundColor(Color.WHITE);
                volleyball.setBackgroundColor(Color.WHITE);
                basketball.setBackgroundColor(Color.WHITE);

                //스포츠 선택 버튼
                switch (v.getId()){
                    //야구
                    case R.id.baseballButton:
                        type = "야구";
                        baseball.setBackgroundColor(Color.rgb(153,102,255));
                        break;
                    //축구
                    case R.id.soccerButton:
                        type = "축구";
                        soccer.setBackgroundColor(Color.rgb(153,102,255));
                        break;
                    //배구
                    case R.id.volleyballButton:
                        type = "배구";
                        volleyball.setBackgroundColor(Color.rgb(153,102,255));
                        break;
                    //농구
                    case R.id.basketballButton:
                        type = "농구";
                        basketball.setBackgroundColor(Color.rgb(153,102,255));
                        break;
                }
            }
        };

        baseball.setOnClickListener(onClickListener);
        soccer.setOnClickListener(onClickListener);
        volleyball.setOnClickListener(onClickListener);
        basketball.setOnClickListener(onClickListener);


        //다음 버튼 클릭시
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventChoiceActivity.this, MainActivity.class);  //일단은 메인으로
                intent.putExtra("sports",type);
                startActivity(intent);
            }
        });

        //뒤로가기 버튼 클릭시
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventChoiceActivity.this, Login.class);  //로그인 화면으로
                startActivity(intent);
            }
        });
    }
}