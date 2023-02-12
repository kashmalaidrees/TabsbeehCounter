package com.example.tasbeehcountere;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "tasbeeh.db";
    private static String TABLE_NAME = "tasbeeh";

    private static String COLUMN_ID =  "id";
    private static String COLUMN_DATE =  "date";
    private static String COLUMN_KALMA = "countKalma";
    private static String COLUMN_DARUD = "countDarud";
    private static String COLUMN_ASTIGFAR =  "countAstigfar";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME+" ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_KALMA + " TEXT, " +
                COLUMN_DARUD + " TEXT, " +
                COLUMN_ASTIGFAR + " TEXT );";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_NAME ;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertTasbeeh(Tasbeeh t)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(COLUMN_DATE, t.getDate());
        value.put(COLUMN_KALMA, t.getCountKalma());
        value.put(COLUMN_DARUD, t.getCountDarud());
        value.put(COLUMN_ASTIGFAR, t.getCountAstigfar());

        db.insert(TABLE_NAME, null, value);

        db.close();

    }

    public List<Tasbeeh> getCountofAll(){
        List<Tasbeeh> Data = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME + " order by " + COLUMN_ID + " DESC ";
        int countkalma = 0, countdarud = 0, countastigfar = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst())
        {
            do{
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") String kalma = cursor.getString(cursor.getColumnIndex(COLUMN_KALMA));
                @SuppressLint("Range") String darud = cursor.getString(cursor.getColumnIndex(COLUMN_DARUD));
                @SuppressLint("Range") String astigfar = cursor.getString(cursor.getColumnIndex(COLUMN_ASTIGFAR));
                countkalma += Integer.parseInt(kalma);
                countdarud += Integer.parseInt(darud);
                countastigfar += Integer.parseInt(astigfar);

            }while (cursor.moveToNext());
        }
        if (countkalma != 0 || countastigfar != 0 || countdarud != 0)
        {
            Data.add(new Tasbeeh(String.valueOf(countkalma) , String.valueOf(countdarud),String.valueOf(countastigfar)));
        }
        cursor.close();
        db.close();

        return Data;
    }

    public List<Tasbeeh> getFromDate(){
        List<Tasbeeh> Data = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME + " order by " + COLUMN_DATE + " ASC limit 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst())
        {
            do{
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") String kalma = cursor.getString(cursor.getColumnIndex(COLUMN_KALMA));
                @SuppressLint("Range") String darud = cursor.getString(cursor.getColumnIndex(COLUMN_DARUD));
                @SuppressLint("Range") String astigfar = cursor.getString(cursor.getColumnIndex(COLUMN_ASTIGFAR));
                Data.add(new Tasbeeh(date,kalma, darud,astigfar));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return Data;
    }

    public List<Tasbeeh> getToDate(){
        List<Tasbeeh> Data = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME + " order by " + COLUMN_DATE + " DESC limit 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst())
        {
            do{
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") String kalma = cursor.getString(cursor.getColumnIndex(COLUMN_KALMA));
                @SuppressLint("Range") String darud = cursor.getString(cursor.getColumnIndex(COLUMN_DARUD));
                @SuppressLint("Range") String astigfar = cursor.getString(cursor.getColumnIndex(COLUMN_ASTIGFAR));
                Data.add(new Tasbeeh(date,kalma, darud,astigfar));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return Data;
    }

    public void emptytable()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "DELETE FROM " + TABLE_NAME;

        db.execSQL(sql);
    }
}
