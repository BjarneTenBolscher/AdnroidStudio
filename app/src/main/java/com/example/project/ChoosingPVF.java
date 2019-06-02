package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class ChoosingPVF extends AppCompatActivity {

    private Spinner typeChoser;
    private ArrayList<PVFname> pvf = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_pvf);
    }

    public void radioButtons(View view) {
        RadioButton rb1 = (findViewById(R.id.Fruit));
        RadioButton rb2 = (findViewById(R.id.Potato));
        RadioButton rb3 = (findViewById(R.id.Vegetable));
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


    public void chosenItem(View view) {
        RadioButton rb1 = (findViewById(R.id.Fruit));
        RadioButton rb2 = (findViewById(R.id.Potato));
        RadioButton rb3 = (findViewById(R.id.Vegetable));
        char indicator = 'F';

        if (rb1.isChecked()) {
            indicator = 'F';
        } else if (rb2.isChecked()) {
            indicator = 'P';
        } else if (rb3.isChecked()) {
            indicator = 'V';
        }

        typeChoser = findViewById(R.id.typeSpinner);
        String itemChosen = typeChoser.getSelectedItem().toString();
        Intent intent = new Intent(this, ChosenCategory.class);
        intent.putExtra("item", itemChosen);
        intent.putExtra("indicator", indicator);
        startActivity(intent);
    }
}
