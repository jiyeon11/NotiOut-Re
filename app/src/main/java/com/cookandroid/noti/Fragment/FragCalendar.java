package com.cookandroid.noti.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.noti.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FragCalendar extends Fragment {
    View view;
    CalendarView calendarView;
    HashMap<String, String> eventMap;
    TextView game,date,time;
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.frag_calendar,container,false);

        calendarView = view.findViewById(R.id.calendarView);
        game = view.findViewById(R.id.game);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);
        eventMap = new HashMap<>();

        eventMap.put("2023-10-22", "SSG 랜더스 vs NC 다이노스\n18:30 ~");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = formatDate(year, month, dayOfMonth);
                updateEventDetails(selectedDate);
            }
        });

        return view;
    }

    private String formatDate(int year, int month, int dayOfMonth) {
        return String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
    }

    private void updateEventDetails(String selectedDate) {
        String eventDetails = eventMap.get(selectedDate);
        if (eventDetails != null) {
            String[] eventInfo = eventDetails.split("\n");
            date.setText(selectedDate);
            game.setText(eventInfo[0]);
            time.setText(eventInfo[1]);
        } else {
            date.setText("");
            game.setText("일정 없음");
            time.setText("");
        }
    }
}
