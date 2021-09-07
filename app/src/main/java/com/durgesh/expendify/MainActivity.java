package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activity onCreate() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
    super.onStart();
        Toast.makeText(this, "Activity onStart() method called", Toast.LENGTH_SHORT).show();
    }


    public void addExpense(View view){
       // Toast.makeText(this, "Add Expense button clicked", Toast.LENGTH_LONG).show();
        Log.i("EXPENSE", "This is a test log");
        Intent i = new Intent(this, add_expense.class);
        startActivity(i);
    }

    public void viewReport(View view){
        // Toast.makeText(this, "Add Expense button clicked", Toast.LENGTH_LONG).show();
        Log.i("REPORTS", "This is a test log");
        Intent i = new Intent(this, reports.class);
        startActivity(i);
    }

    public void viewBudget(View view){
        // Toast.makeText(this, "Add Expense button clicked", Toast.LENGTH_LONG).show();
        Log.i("Budget", "This is a test log");
        Intent i = new Intent(this, budget.class);
        startActivity(i);
    }

    public void viewAnalysis(View view){
        // Toast.makeText(this, "Add Expense button clicked", Toast.LENGTH_LONG).show();
        Log.i("Analysis", "This is a test log");
        Intent i = new Intent(this, analysis.class);
        startActivity(i);
    }
}