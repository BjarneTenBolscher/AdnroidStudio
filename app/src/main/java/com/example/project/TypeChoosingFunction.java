package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class TypeChoosingFunction extends AppCompatActivity {

    private int position;
    private ArrayList<PVFname> pvf = new ArrayList<>();
    private TextView informationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_choosing_function);
        position = getIntent().getIntExtra("position", 5);
        pvf = DataProvider.pvf;
        informationView = findViewById(R.id.InformationView);
        informationView.setText("Type name: " + pvf.get(position).getName());
    }

    public void goToTypeEditingScreen(View view) {
        Intent intent = new Intent(this, TypeEditing.class);
                intent.putExtra("position", position);
        startActivity(intent);
    }

    public void RemoveType(View view) {
        ShowList.alreadyDeleted = pvf.get(position).getName();
        pvf.remove(position);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        informationView = findViewById(R.id.InformationView);
        informationView.setText("Type name: " + pvf.get(position).getName());
    }
}
