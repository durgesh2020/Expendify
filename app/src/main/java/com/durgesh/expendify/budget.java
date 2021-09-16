package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class budget extends AppCompatActivity {
    Float remaining_budget=0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        setTitle("Budget");
    }

    public  void addBudget(View view)
    {
       /* SharedPreferences pref = getSharedPreferences("Expendify",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.contains("budget") && pref.contains("total_expenses")){
            Float te=pref.getFloat("total_expenses",0.0f);
            Float budget = pref.getFloat("budget",0.0f);
            remaining_budget = budget-te;
        }*/
        EditText txtBudget = (EditText)findViewById(R.id.txtBudget);
        DBHelper db =  new DBHelper(this);
        db.addBudget(Float.parseFloat(txtBudget.getText().toString()));
    }

    public  void viewRemaining(View view)
    {

    }
}