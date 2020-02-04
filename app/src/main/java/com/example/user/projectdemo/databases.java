package com.example.user.projectdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databases extends SQLiteOpenHelper{

    public static final String database_name = "stocks.db";
    public static final String Table_stock = "table1";
    public static final String stock_ID = "ID";
    public static final String stock_Name = "NAME";
    public static final String stock_Group = "BLOOD_GROUP";
    public static final String stock_Number = "PHONE_NUMBER";
    public static final String stock_Add= "AREA";

   // private Context context;


    public databases(Context context) {
        super(context, database_name, null, 1);
      //  this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + Table_stock+ " ( ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , BLOOD_GROUP TEXT , PHONE_NUMBER TEXT UNIQUE , AREA TEXT ) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS "+ Table_stock );
        onCreate(db);

    }

    public long InsertData(String name, String group, String num, String area){

        SQLiteDatabase db =  this.getReadableDatabase();

        ContentValues contentvalues = new ContentValues();

        contentvalues.put(stock_Name,name);
        contentvalues.put(stock_Group,group);
        contentvalues.put(stock_Number,num);
        contentvalues.put(stock_Add,area);

       long res = db.insert(Table_stock, null , contentvalues );

       return res ;

    }

    public Cursor getquery(String bloodgroup, String area){

        String[] args = {bloodgroup, area};


        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT PHONE_NUMBER FROM " + Table_stock +" WHERE BLOOD_GROUP = ? AND AREA = ?" , args);
        return  res;


    }
}