package com.durgesh.expendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class analysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        setTitle("Analysis");
        TextView lblAnalysis = (TextView)findViewById(R.id.lblAnalysis);
        SharedPreferences pref = getSharedPreferences("Expendify",MODE_PRIVATE);
        if(pref.contains("ae_amount") && pref.contains("ae_category")){
            float amount = pref.getFloat("ae_amount",0.0f);
            String category=pref.getString("ae_category",null);
            lblAnalysis.setText(category+": Rs. "+amount);
        }
    }

    public  void viewHome(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}