package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        setTitle("Reports");
        TextView txtReport=(TextView)findViewById(R.id.txtReport);
        SharedPreferences pref = getSharedPreferences("Expendify",MODE_PRIVATE);
        Float te=pref.getFloat("total_expenses",0.0f);
        txtReport.setText("Total Expense:\nRs."+te.toString()+"/-");
    }

    public  void viewHome(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}       `111