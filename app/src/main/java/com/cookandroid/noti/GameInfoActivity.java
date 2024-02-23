package com.cookandroid.noti;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameInfoActivity extends AppCompatActivity {
    ImageButton reservationButton;
    TextView date, place, gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        Intent intent = getIntent();
        reservationButton = findViewById(R.id.reservationButton);
        date = findViewById(R.id.date);
        place = findViewById(R.id.place);
        gameName = findViewById(R.id.gameName);
        reservationButton = findViewById(R.id.reservationButton);

        place.setText(intent.getStringExtra("place"));  //장소
        date.setText(intent.getStringExtra("date"));  //시간
        gameName.setText(intent.getStringExtra("game_name")+" "+intent.getStringExtra("team1")+" vs "+intent.getStringExtra("team2"));//경기 이름

        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameInfoActivity.this, ReservationActivity.class);  //경기 상세정보로
                startActivity(intent);
            }
        });
    }
}