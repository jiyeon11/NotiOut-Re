package com.cookandroid.noti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notiout.db";
    private static final int DATABASE_VERSION = 2;

    public DBHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.disableWriteAheadLogging();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        sqLiteDatabase.execSQL("CREATE TABLE user (id varchar(15) NOT NULL, name varchar(6) NOT NULL, pw varchar(15) NOT NULL, PRIMARY KEY(id));");
        sqLiteDatabase.execSQL("INSERT INTO user VALUES ('purejava','이순자','jiyeon18')");
        sqLiteDatabase.execSQL("INSERT INTO user VALUES ('notiti','김노티','notigetout')");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS schedule");
        sqLiteDatabase.execSQL("CREATE TABLE schedule (id INTEGER PRIMARY KEY AUTOINCREMENT, sports varchar(3), game_name varchar(20), date DATETIME, team1_name varchar(20), team2_name varchar(20), place varchar(20));");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('야구', 'KBO 리그', '2024-03-01 18:30:00', '삼성 lions', 'LG twins', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('야구', 'KBO 리그', '2024-03-02 18:30:00', 'KT wiz', 'LG twins', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('배구', 'V리그', '2024-03-02 19:00:00', '현대건설', '정관장', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('배구', 'V리그', '2024-03-07 19:00:00', '현대건설', '흥국생명', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('축구', 'K리그', '2024-03-03 20:00:00', '강원FC', '울산FC', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('축구', 'K리그', '2024-03-12 20:00:00', '강원FC', 'FC서울', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('농구', 'KBL 리그', '2024-03-04 19:30:00', '피버스', '프로미', '인천 SSG 랜더스필드')");
        sqLiteDatabase.execSQL("INSERT INTO schedule (sports, game_name, date, team1_name, team2_name, place) VALUES ('농구', 'KBL 리그', '2024-03-09 19:30:00', '프로미', '소닉붐', '인천 SSG 랜더스필드')");
    }

    public List<Schedule> getSchedule(String sports, String liked){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Schedule> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM schedule WHERE sports ='"+sports+"' AND (team1_name = '"+liked+"' OR team2_name = '"+liked+"')",null);
        if (cursor.moveToFirst()) {
            do {
                String gameName = cursor.getString(2);
                String date = cursor.getString(3);
                String team1 = cursor.getString(4);
                String team2 = cursor.getString(5);
                String place = cursor.getString(6);
                Schedule schedule = new Schedule(gameName, date, team1, team2, place);
                list.add(schedule);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }
    public String getUserID(String edit_id){  //id
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM user WHERE id ='"+edit_id+"'",null);
        String id = "";
        if (cursor.moveToFirst()) {
            id = cursor.getString(0);
            cursor.close();
            return id;
        } else {
            cursor.close();
            return null;
        }
    }

    public String getUserName(String edit_id){  //name
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM user WHERE id ='"+edit_id+"'",null);
        cursor.moveToFirst();
        String name = cursor.getString(0);
        cursor.close();
        return name;
    }

    public String getUserPW(String edit_id){  //pw
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT pw FROM user WHERE id ='"+edit_id+"'",null);
        if (cursor.moveToFirst()) {
            String pw = cursor.getString(0);
            cursor.close();
            return pw;
        } else {
            cursor.close();
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
