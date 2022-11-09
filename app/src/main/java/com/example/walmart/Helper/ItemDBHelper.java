package com.example.walmart.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class ItemDBHelper extends SQLiteOpenHelper {
    public ItemDBHelper( Context context,String name) {
        super(context, name, null, 1);
    }
    public void QueryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String i_name,String i_cat,
                           String i_price,String i_dis ,byte [] i_image){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO COSTOMER VALUES (NULL,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,i_name);
        statement.bindString(2,i_cat);
        statement.bindString(3,i_price);
        statement.bindString(4,i_dis);
        statement.bindBlob(5,i_image);
        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql ,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
