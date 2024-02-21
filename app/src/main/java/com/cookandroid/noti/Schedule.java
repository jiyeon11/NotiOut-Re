package com.cookandroid.noti;

import android.util.Log;

public class Schedule {  //경기 일정 클래스
    private String gameName;
    private String date;
    private String team1;
    private String team2;
    private String place;

    public Schedule(String gameName, String date, String team1, String team2, String place) {
        this.gameName = gameName;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.place = place;
    }

    public String getGameName() {
        return gameName;
    }

    public String getDate() { return date; }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getPlace() {
        return place;
    }
}
