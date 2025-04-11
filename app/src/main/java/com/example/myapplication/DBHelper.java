package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDB";
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE mytable(id INTEGER PRIMARY KEY, name TEXT, address TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
    }

    public void insertData(int id, String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("Address", address);
        db.insert("mytable", null, contentValues);
        db.close();
    }

    public Cursor selectData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM mytable";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    // write functions to update and delete see book p-175
}