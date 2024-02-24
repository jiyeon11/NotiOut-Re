package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ReservationActivity extends AppCompatActivity {
    TextView gameName,date, place,ticket;
    ToggleButton toggleADayAgo, toggleAHourAgo, toggle10minAgo, togglestart;
    ImageButton addAlarmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        gameName = findViewById(R.id.gameName);
        date = findViewById(R.id.date);
        place = findViewById(R.id.place);
        ticket = findViewById(R.id.ticket);
        toggleADayAgo = findViewById(R.id.toggleADayAgo);
        toggleAHourAgo = findViewById(R.id.toggleAHourAgo);
        toggle10minAgo = findViewById(R.id.toggle10minAgo);
        togglestart = findViewById(R.id.togglestart);
        addAlarmButton = findViewById(R.id.addAlarmButton);
        Intent intent = getIntent();
        gameName.setText(intent.getStringExtra("game_name"));
        date.setText(intent.getStringExtra("date"));
        place.setText(intent.getStringExtra("place"));
    }
}