package com.cookandroid.noti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notiout.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        sqLiteDatabase.execSQL("CREATE TABLE user (id varchar(15) NOT NULL, name varchar(6) NOT NULL, pw varchar(15) NOT NULL, PRIMARY KEY(id));");
        sqLiteDatabase.execSQL("INSERT INTO user VALUES ('purejava','이순자','jiyeon18')");
        sqLiteDatabase.execSQL("INSERT INTO user VALUES ('notiti','김노티','notigetout')");
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
