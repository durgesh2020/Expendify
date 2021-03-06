package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        setTitle("Reports");
        TextView txtReport=(TextView)findViewById(R.id.txtReport);
       /* SharedPreferences pref = getSharedPreferences("Expendify",MODE_PRIVATE);
        Float te=pref.getFloat("total_expenses",0.0f);*/
        DBHelper db = new DBHelper(this);
        float te = db.getTotalExpenses();
        txtReport.setText("Total Expense:\nRs."+ Float.toString(te) +"/-");
        Toast.makeText(this, "Welcome to the github repository!", Toast.LENGTH_SHORT).show();
    }

    public  void viewHome(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}      