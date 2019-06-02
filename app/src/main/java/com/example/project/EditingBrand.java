package com.example.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class EditingBrand extends AppCompatActivity {

    private static ArrayList<PVFname> pvf = new ArrayList<>();
    private TextView editName;
    private TextView editCosts;
    private String newName;
    private Double newCost;
    private int position;
    private String chosenItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_brand);
        position = getIntent().getIntExtra("brandPosition", 5);
        chosenItem = getIntent().getStringExtra("chosenItem");
        pvf = DataProvider.pvf;


        editCosts = findViewById(R.id.editCosts);
        editName = findViewById(R.id.editName);


        PVFname pvFname;
        for (int i = 0; i < pvf.size(); i++) {
            pvFname = pvf.get(i);

            if (pvFname.getBrands().get(position).getItemName().equals(chosenItem)) {
                editCosts.setText(Double.toString(pvFname.getBrands().get(position).getCosts()));
                editName.setText(pvFname.getBrands().get(position).getItemName());
                break;
            }
        }

    }

    public void editBrand(View view) {
        int position = getIntent().getIntExtra("brandPosition", 5);
        String chosenItem = getIntent().getStringExtra("chosenItem");

        newName = editName.getText().toString();
        newCost = Double.parseDouble(editCosts.getText().toString());

        PVFname pvFname;

        for (int i = 0; i < pvf.size(); i++) {
            pvFname = pvf.get(i);
            if (pvFname.getBrands().get(position).getItemName().equals(chosenItem)) {
                pvFname.getBrands().get(position).setBrands(newName);
                pvFname.getBrands().get(position).setCosts(newCost);
                finish();
            }
        }

    }

}
