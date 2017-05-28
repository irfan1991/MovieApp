package com.andaratech.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Report");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
