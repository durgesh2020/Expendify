package com.durgesh.expendify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        String tblExpense = "CREATE TABLE \"tblExpense\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"category\"\tTEXT NOT NULL,\n" +
                "\t\"comment\"\tTEXT,\n" +
                "\t\"amount\"\tREAL NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ")";

        String tblBudget = "CREATE TABLE \"tblBudget\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"amount\"\tREAL NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(tblExpense);
        db.execSQL(tblBudget);
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
        values.put("category", ex.getCategory());
        values.put("comment", ex.getComment());
        values.put("amount", ex.getAmount());
        db.insert("tblExpense",null,values);
        db.close();
    }

    float getTotalExpenses()
    {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor c =  db.rawQuery( "select SUM(amount) as expenses from tblExpense;", null);
        if (c.moveToFirst())
        {
            c.close();
            return Float.parseFloat(c.getString(0));
        }
        c.close();
        return 0;
    }

    boolean addBudget(float budget)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", budget);
        long status = db.insert("tblBudget",null,values);
        db.close();
        return status > 0;
    }
}
