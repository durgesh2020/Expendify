package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class add_expense extends AppCompatActivity {
    String name, category, comment ;
    Float amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        setTitle("Add Expense");
    }

    public void addExpense(View view)
    {
        EditText txtName = (EditText)findViewById(R.id.txtName);
        EditText txtCategory = (EditText)findViewById(R.id.txtCategory);
        EditText txtComment = (EditText)findViewById(R.id.txtComment);
        EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
        name=txtName.getText().toString();
        category=txtCategory.getText().toString();
        comment=txtComment.getText().toString();
        amount=Float.parseFloat(txtAmount.getText().toString());
       // Toast.makeText(this, "Values:\n"+name+"\n"+category+"\n"+comment+"\n"+amount, Toast.LENGTH_SHORT).show();
        SharedPreferences pref = getSharedPreferences("Expendify",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("ae_name", name);
        editor.putString("ae_category", category);
        editor.putString("ae_comment", comment);
        editor.putFloat("ae_amount", amount);

        Float total_expenses = 0.0f;
        if(pref.contains("total_expenses")){
            total_expenses=pref.getFloat("total_expenses",0.0f);
//            Log.i("mytag",total_expenses.toString());
            total_expenses=total_expenses+amount;
//            Log.i("mytag",total_expenses.toString());
//            Log.i("mytag",amount.toString());
            editor.putFloat("total_expenses", total_expenses);
        }
        else
            editor.putFloat("total_expenses", amount);
        editor.apply();
        Float am=0.0f;
        Float te=0.0f;
        Toast.makeText(this, pref.getString("ae_name",null)+"\n"+pref.getString("ae_category",null)+"\n"+pref.getString("ae_comment",null)+"\n"+pref.getFloat("ae_amount",am)+"\n"+pref.getFloat("total_expenses",te), Toast.LENGTH_SHORT).show();


    }
}