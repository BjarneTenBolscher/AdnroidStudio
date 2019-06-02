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
        char pvfChar = pvf.toLowerCase().charAt(0);
            if (!name.equals("")) {
                pvf.toUpperCase();
                if (pvf.equals(this.getResources().getString(R.string.vegetable)) || pvfChar == 'v') {
                    pvf = "Vegetable";
                } else if (pvf.equals(this.getResources().getString(R.string.fruit)) || pvfChar == 'f') {
                    pvf = "Fruit";
                } else {
                    pvf = "Potato";
                }
                DataProvider.addType(name, pvf);
                finish();
            }
    }
}
