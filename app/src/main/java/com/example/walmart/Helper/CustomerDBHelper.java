package com.example.walmart.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class CustomerDBHelper extends SQLiteOpenHelper {
    public CustomerDBHelper(Context context, String name, Object o, int i){
        super(context, name, null, 1);
    }
    public void queryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String name,String add , byte[] image){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO COSTOMER VALUES (NULL,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,add);
        statement.bindBlob(3,image);
        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
