package com.example.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project.Model.DataProvider;

public class TypeAddingActivity extends AppCompatActivity {
    TextView typeView;
    TextView pvfType;
    String pvf = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_adding);
    }

    public void addType(View view) {
        typeView = findViewById(R.id.TypeName);
        pvfType = findViewById(R.id.WhatPVF);
        name = typeView.getText().toString();
        pvf = pvfType.getText().toString();

        if (!name.equals("") || !pvf.equals("")) {
            pvf.toUpperCase();
            if (pvf.equals(this.getResources().getString(R.string.vegetable))) {
                pvf = "Vegetable";
            } else if (pvf.equals(this.getResources().getString(R.string.fruit))) {
                pvf = "Fruit";
            } else {
                pvf = "Potato";
            }
            DataProvider.addType(name, pvf);
            finish();
        }
    }
}
