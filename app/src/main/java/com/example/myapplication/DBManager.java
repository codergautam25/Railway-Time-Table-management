package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final String dbName = "UserDataBase.db";


    public DBManager(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table user_details ( id integer primary key autoincrement , name text,mobile text,email text,password text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS user_details ");
        onCreate(db);

    }

    public String addRecord(String n,String m,String e,String p){

        Cursor cr = getAllData();
        while (cr.moveToNext()){
            if(cr.getString(2).equals(m) ){
                return "You are already registered";
            }
            else if(cr.getString(3).equals(e)){
                return "You are already registered";
            }
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",n);
        cv.put("mobile",m);
        cv.put("email",e);
        cv.put("password",p);


        Long res = db.insert("user_details",null,cv);

        if(res == -1){
            return "Insertion failed";
        }
        else
            return "Successfully Inserted";
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from user_details",null);
        return res;
    }
}

