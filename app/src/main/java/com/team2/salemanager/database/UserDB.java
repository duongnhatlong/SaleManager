package com.team2.salemanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created By JohnNguyen - Onesoft on 28/11/2018
 */
public class UserDB extends SQLiteOpenHelper {
    public UserDB(Context context) {
        super(context, "User", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlUser = "CREATE TABLE User(Id integer primary key ," + "Name text, Birth text, Address text, Phone text, Image blob)";
        db.execSQL(sqlUser);

        String sqlAdmin = "CREATE TABLE Admin"

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}