package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project.Model.Brand;
import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;
import java.util.List;

public class ChoseFunction extends AppCompatActivity {

    private static ArrayList<PVFname> pvf = new ArrayList<>();
    private static ArrayList<Brand> brands = new ArrayList<>();
    private TextView informationView;
    private int position;
    private int typePos;
    private char indicator;
    private int removed;
    public static ArrayList<PVFname> res;
    private String chosenItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_function);

        position = getIntent().getIntExtra("brandPosition", 5);
        typePos = getIntent().getIntExtra("typePos", 5);
        pvf = DataProvider.pvf;
        indicator = getIntent().getCharExtra("indicator", 'F');
        chosenItem = getIntent().getStringExtra("chosenItem");
        PVFname pvFname;
        removed = 0;
        for (int i = 0; i < pvf.size(); i++) {
            pvFname = pvf.get(i);
            if (pvFname.getIndicator() == indicator) {
                if (chosenItem.equals(pvFname.getName())) {
                    brands = DataProvider.getBrands(indicator);
                }
            }
        }
        informationView = findViewById(R.id.InformationView);
        informationView.setText("Brand name: " + brands.get(position).getItemName() + "\n" + "Cost: " + brands.get(position).getCosts());
    }

    public void GoToEditingScreen(View view) {
        Intent intent = new Intent(this, EditingBrand.class);
            intent.putExtra("brandPosition", position);
            intent.putExtra("indicator", indicator);
            intent.putExtra("chosenItem", brands.get(position).getItemName());
        startActivity(intent);
    }

    public void RemoveBrand(View view) {
        if (removed == 0) {
            pvf.get(typePos).getBrands().remove(position);
            finish();
            removed++;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        informationView = findViewById(R.id.InformationView);
        informationView.setText("Brand name: " + brands.get(position).getItemName() + "\n" + "Cost: " + brands.get(position).getCosts());
    }
}
