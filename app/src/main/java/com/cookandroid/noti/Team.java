package com.cookandroid.noti;

public class Team {
    private int logoResId;  // 로고 이미지의 id
    private String name;  // 팀 이름

    public Team(int logoResId, String name) {
        this.logoResId = logoResId;
        this.name = name;
    }

    public int getLogoResId() {
        return logoResId;
    }

    public String getName() {
        return name;
    }
}
