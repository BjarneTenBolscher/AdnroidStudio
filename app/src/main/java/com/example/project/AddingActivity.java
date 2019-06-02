package com.example.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class AddingActivity extends AppCompatActivity {

    private Spinner typeChoser;
    private ArrayList<PVFname> pvf = new ArrayList<>();
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private ArrayList<String> names = new ArrayList<>();
    private TextView costAdd;
    private TextView brandAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void radioButtons(View view) {
        rb1 = (findViewById(R.id.Fruit));
        rb2 = (findViewById(R.id.Potato));
        rb3 = (findViewById(R.id.Vegetable));
        DataProvider dataProvider = DataProvider.getInstance(this);
        ArrayAdapter<String> adapter;
        if (rb1.isChecked()) {
            names.clear();
            pvf = dataProvider.getPVF();
            for (int i = 0; i < pvf.size(); i++) {
                if (pvf.get(i).getIndicator() == 'F') {
                    names.add(pvf.get(i).getName());
                }
            }
            typeChoser = findViewById(R.id.typeSpinner);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);
            typeChoser.setAdapter(adapter);

        } else if (rb2.isChecked()) {

            names.clear();
            pvf = dataProvider.getPVF();
            for (int i = 0; i < pvf.size(); i++) {
                if (pvf.get(i).getIndicator() == 'P') {
                    names.add(pvf.get(i).getName());
                }
            }
            typeChoser = findViewById(R.id.typeSpinner);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);
            typeChoser.setAdapter(adapter);

        } else if (rb3.isChecked()) {

            names.clear();
            pvf = dataProvider.getPVF();

            for (int i = 0; i < pvf.size(); i++) {
                if (pvf.get(i).getIndicator() == 'V') {
                    names.add(pvf.get(i).getName());
                }
            }
            typeChoser = findViewById(R.id.typeSpinner);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);
            typeChoser.setAdapter(adapter);
        }
    }

    public void addingButton(View view) {
        rb1 = (findViewById(R.id.Fruit));
        rb2 = (findViewById(R.id.Potato));
        rb3 = (findViewById(R.id.Vegetable));
        brandAdd = findViewById(R.id.BrandText);
        costAdd = findViewById(R.id.CostBox);

        String addedBrand = brandAdd.getText().toString();
        String temp = costAdd.getText().toString();

        if (!addedBrand.equals("") || !temp.equals("") || rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
            double costAdded = Double.parseDouble(temp);
            char indicator;
            Object type = typeChoser.getSelectedItem();
            String chosen = type.toString();
            if (rb1.isChecked()) {
                indicator = 'F';
            } else if (rb2.isChecked()) {
                indicator = 'P';
            } else {
                indicator = 'V';
            }

            DataProvider.addBrand(addedBrand, costAdded, chosen, indicator);
            finish();
        }
    }
}
