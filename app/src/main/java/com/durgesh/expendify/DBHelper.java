package com.durgesh.expendify;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context)
    {
        super(context,"db_expendify",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql_query = "CREATE TABLE \"tblExpense\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"category\"\tTEXT NOT NULL,\n" +
                "\t\"comment\"\tTEXT,\n" +
                "\t\"amount\"\tREAL NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ") UNION CREATE TABLE \"tblBudget\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"amount\"\tREAL NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(sql_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql_query = "drop table if exists tblExpense;";
        db.execSQL(sql_query);
    }

    void addExpense(Expense ex)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", ex.getName());
        values.put("category", ex.getName());
        values.put("comment", ex.getName());
        values.put("amount", ex.getName());
        db.insert("tblExpense",null,values);
        db.close();
    }
}
