package com.cookandroid.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Team_Search_Activity extends AppCompatActivity {
    ImageButton completeButton, backButton;
    TextView sports,team;
    androidx.appcompat.widget.SearchView searchView;
    String sports_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search);

        completeButton = findViewById(R.id.completeButton);
        backButton = findViewById(R.id.backButton);
        sports = findViewById(R.id.sports);
        searchView = findViewById(R.id.search_view);
        team = findViewById(R.id.team);
        ListView listView = findViewById(R.id.list_view);
        Intent intent = getIntent();
        sports_name = intent.getStringExtra("sports");
        sports.setText(sports_name);
        List<Team> teams = loadTeams();  // 구단 데이터를 로드

        //검색
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {

            //검색 버튼을 눌렀을 경우
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            //텍스트가 바뀔 때마다
            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    listView.setVisibility(View.VISIBLE);  // 검색어가 입력되면 ListView를 보이게
                } else {
                    listView.setVisibility(View.GONE);  // 검색어가 없으면 ListView를 숨기기
                }
                List<Team> filterteams = new ArrayList<>();
                for(int i = 0; i<teams.size(); i++){
                    Team team = teams.get(i);
                    if(team.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterteams.add(team);
                    }
                }
                TeamAdapter adapter = new TeamAdapter(getApplicationContext(), filterteams);
                listView.setAdapter(adapter);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team selectedItem = (Team) parent.getItemAtPosition(position);
                team.setText(selectedItem.getName());
                team.setVisibility(View.VISIBLE);  //보이게
                listView.setVisibility((View.GONE));  //리스트뷰 숨김
            }
        });

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

    private List<Team> loadTeams() {
        List<Team> teams = new ArrayList<>();
        if(sports_name.equals("야구")){
            teams.add(new Team(R.drawable.lions, "삼성 lions"));
            teams.add(new Team(R.drawable.twins, "LG twins"));
            teams.add(new Team(R.drawable.wiz, "KT wiz"));
        }else if(sports_name.equals("축구")){
            teams.add(new Team(R.drawable.ulsan, "울산FC"));
            teams.add(new Team(R.drawable.gangwon, "강원FC"));
            teams.add(new Team(R.drawable.seoul, "FC서울"));
        }else if(sports_name.equals("농구")){
            teams.add(new Team(R.drawable.promy, "프로미"));
            teams.add(new Team(R.drawable.phoebus, "피버스"));
            teams.add(new Team(R.drawable.sonicboom, "소닉붐"));
        }else if(sports_name.equals("배구")){
            teams.add(new Team(R.drawable.hillstate, "현대건설"));
            teams.add(new Team(R.drawable.pinkspiders, "흥국생명"));
            teams.add(new Team(R.drawable.redsparks, "정관장"));
        }

        return teams;
    }
}