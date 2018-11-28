package com.team2.salemanager.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.team2.salemanager.SqliteHelper.SqliteHelper;

public class UserDAO {
    private SQLiteDatabase db;
    private SqliteHelper dbHelper;
    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (username text primary key, password text, phone text, hoten text);";
    public static final String TAG = "NguoiDungDAO";

    public UserDAO(Context context) {
        dbHelper = new SqliteHelper(context);
        db = dbHelper.getWritableDatabase();
    }


}
