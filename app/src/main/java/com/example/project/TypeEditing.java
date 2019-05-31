package com.example.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class TypeEditing extends AppCompatActivity {

    private ArrayList<PVFname> pvf = new ArrayList<>();
    private int position;
    private TextView editNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_editing);
        position = getIntent().getIntExtra("position", 0);
        pvf = DataProvider.pvf;
        pvf.get(position).getName();
        editNameField = findViewById(R.id.editTypeName);
        editNameField.setText(pvf.get(position).getName());
    }

    public void editType(View view) {
        String newName = editNameField.getText().toString();
        pvf.get(position).setName(newName);
        finish();
    }
}
