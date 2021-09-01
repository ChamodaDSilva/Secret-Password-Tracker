package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DB_NAME="item";
    private static final String TABLE_NAME="item";

    //columns names
    private static final String ID="id";
    private static final String DESCRIPTION="description";
    private static final String USER_NAME="userName";
    private static final String PASSWORD="password";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //created the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +DESCRIPTION+" TEXT,"
                +USER_NAME+" TEXT,"
                +PASSWORD+" TEXT"+
                ");";
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }

    //insert data

    public void addItem(Item item){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DESCRIPTION,item.getDescription());
        contentValues.put(USER_NAME,item.getUserName());
        contentValues.put(PASSWORD,item.getPassword());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    //get data from db
    public List<Item> getAllItems(){
        List<Item> items=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Item item=new Item();
                item.setId(cursor.getInt(0));
                item.setDescription(cursor.getString(1));
                item.setUserName(cursor.getString(2));
                item.setPassword(cursor.getString(3));
                items.add(item);
            }while (cursor.moveToNext());
        }

        return items;
    }
    //deleter data from db
    public void deleteItem(int id){
        SQLiteDatabase db= getWritableDatabase();
        db.delete(TABLE_NAME,ID+" =?",new String[]{String.valueOf(id)});
        db.close();
    }

    //select single row of a db and get data fromm that
    public Item getSingleItem(int id){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{ID,DESCRIPTION,USER_NAME,PASSWORD},ID+"= ?",new String[]{String.valueOf(id)},
                null,null,null);

        Item item;

        if(cursor!=null){
            cursor.moveToFirst();
            item=new Item(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return item;
        }
        return null;
    }

    //update a single row
    public int updateSingleItem(Item item){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DESCRIPTION,item.getDescription());
        contentValues.put(USER_NAME,item.getUserName());
        contentValues.put(PASSWORD,item.getPassword());

        int status=db.update(TABLE_NAME,contentValues,ID+"= ?",new String[]{String.valueOf(item.getId())});

        db.close();
        return status;
    }
}
