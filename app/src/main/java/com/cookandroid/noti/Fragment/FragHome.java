package com.cookandroid.noti.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.noti.DBHelper;
import com.cookandroid.noti.GameInfoActivity;
import com.cookandroid.noti.MainActivity;
import com.cookandroid.noti.R;
import com.cookandroid.noti.Schedule;

import java.util.List;

public class FragHome extends Fragment {
    View view;
    TextView date, game_name, team1, team2, place;
    Button baseball, soccer, basketball, volleyball, liked;
    String sports;
    LinearLayout schedule_layout;
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.frag_home,container,false);
        baseball = view.findViewById(R.id.baseball);
        soccer = view.findViewById(R.id.soccer);
        basketball = view.findViewById(R.id.basketball);
        volleyball = view.findViewById(R.id.volleyball);
        liked = view.findViewById(R.id.liked);
        sports = getArguments().getString("sports");
        liked.setText(getArguments().getString("likeTeam"));

        Button.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseball.setTextColor(Color.BLACK);
                soccer.setTextColor(Color.BLACK);
                volleyball.setTextColor(Color.BLACK);
                basketball.setTextColor(Color.BLACK);

                //스포츠 선택 버튼
                switch (v.getId()){
                    //야구
                    case R.id.baseball:
                        sports = "야구";
                        baseball.setTextColor(Color.rgb(153,102,255));
                        break;
                    //축구
                    case R.id.soccer:
                        sports = "축구";
                        soccer.setTextColor(Color.rgb(153,102,255));
                        break;
                    //배구
                    case R.id.volleyball:
                        sports = "배구";
                        volleyball.setTextColor(Color.rgb(153,102,255));
                        break;
                    //농구
                    case R.id.basketball:
                        sports = "농구";
                        basketball.setTextColor(Color.rgb(153,102,255));
                        break;
                }

                DBHelper sDB = new DBHelper(getActivity());
                List<Schedule> schedules = sDB.getSchedule(sports, String.valueOf(liked.getText()));
                LinearLayout rootLayout = view.findViewById(R.id.rootLayout);
                rootLayout.removeAllViews();  //초기화

                for (Schedule schedule : schedules) {
                    schedule_layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.schedule_layout, rootLayout, false);

                    date = schedule_layout.findViewById(R.id.date);
                    game_name = schedule_layout.findViewById(R.id.game_name);
                    team1 = schedule_layout.findViewById(R.id.team1);
                    team2 = schedule_layout.findViewById(R.id.team2);
                    place = schedule_layout.findViewById(R.id.place);
                    ImageView logo1 = schedule_layout.findViewById(R.id.logo1);
                    ImageView logo2 = schedule_layout.findViewById(R.id.logo2);

                    date.setText(schedule.getDate().substring(5,10));  //날짜 설정
                    game_name.setText(schedule.getGameName());  //경기 이름
                    team1.setText(schedule.getTeam1());  //팀1
                    team2.setText(schedule.getTeam2());  //팀2
                    place.setText(schedule.getPlace());  //경기장 장소
                    logo1.setImageResource(getLogo(schedule.getTeam1()));  //팀1 로고
                    logo2.setImageResource(getLogo(schedule.getTeam2()));  //팀2 로고
                    rootLayout.addView(schedule_layout);

                    schedule_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), GameInfoActivity.class);  //경기 상세정보로
                            intent.putExtra("date", schedule.getDate());
                            intent.putExtra("game_name", schedule.getGameName());
                            intent.putExtra("team1", schedule.getTeam1());
                            intent.putExtra("team2", schedule.getTeam2());
                            intent.putExtra("place", schedule.getPlace());
                            startActivity(intent);
                        }
                    });
                }
            }
        };

        baseball.setOnClickListener(onClickListener);
        soccer.setOnClickListener(onClickListener);
        volleyball.setOnClickListener(onClickListener);
        basketball.setOnClickListener(onClickListener);

        switch(sports){  //버튼 클릭 이벤트 실행
            case "야구": baseball.performClick(); break;
            case "축구": soccer.performClick(); break;
            case "배구": volleyball.performClick(); break;
            case "농구": basketball.performClick(); break;
        }


        return view;
    }

    //로고 이미지
     int getLogo(String teamName){
         int logo = 0;

         switch (teamName){
             case "삼성 lions" : logo = R.drawable.lions; break;
             case "LG twins" : logo = R.drawable.twins; break;
             case "KT wiz" : logo = R.drawable.wiz; break;
             case "울산FC" : logo = R.drawable.ulsan; break;
             case "강원FC" : logo = R.drawable.gangwon; break;
             case "FC서울" : logo = R.drawable.seoul; break;
             case "프로미" : logo = R.drawable.promy; break;
             case "피버스" : logo = R.drawable.phoebus; break;
             case "소닉붐" : logo = R.drawable.sonicboom; break;
             case "현대건설" : logo = R.drawable.hillstate; break;
             case "흥국생명" : logo = R.drawable.pinkspiders; break;
             case "정관장" : logo = R.drawable.redsparks; break;
         }
        return logo;
    }
}
