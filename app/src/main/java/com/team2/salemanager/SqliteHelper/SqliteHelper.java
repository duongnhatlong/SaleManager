package com.team2.salemanager.SqliteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.team2.salemanager.DAO.UserDAO;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context) {
        super(context, "SaleManager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng
        db.execSQL(UserDAO.SQL_NGUOI_DUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
