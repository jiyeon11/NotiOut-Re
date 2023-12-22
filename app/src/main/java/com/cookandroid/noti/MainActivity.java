package com.cookandroid.noti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.webkit.WebView;

import com.cookandroid.noti.Fragment.FragAlram;
import com.cookandroid.noti.Fragment.FragCalendar;
import com.cookandroid.noti.Fragment.FragHome;
import com.cookandroid.noti.Fragment.FragProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    Fragment fragment_home;
    Fragment fragment_calendar;
    Fragment fragment_alram;
    Fragment fragment_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_home = new FragHome();
        fragment_calendar = new FragCalendar();
        fragment_alram = new FragAlram();
        fragment_profile = new FragProfile();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 초기 화면으로 홈 프래그먼트를 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment_home).commitAllowingStateLoss();
                        return true;
                    case R.id.alarm:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment_alram).commitAllowingStateLoss();
                        return true;
                    case R.id.calendar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment_calendar).commitAllowingStateLoss();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment_profile).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });
    }
}