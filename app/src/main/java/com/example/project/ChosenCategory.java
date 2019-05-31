package com.example.project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.project.Adapters.DataItemAdapter;
import com.example.project.Model.Brand;
import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class ChosenCategory extends AppCompatActivity {

    private String chosenItem = "";
    private char indicator;
    private static ArrayList<Brand> brands = new ArrayList<>();
    private static ArrayList<PVFname> pvf = new ArrayList<>();
    public DataItemAdapter adapter;
    private ListView rv;
    private int typePos;
    public static int deleted = -1;
    private DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_category);
        chosenItem = getIntent().getStringExtra("item");
        dataProvider = DataProvider.getInstance(this);
        pvf.clear();
        brands.clear();
        pvf = dataProvider.getPVF();
        for (int i = 0; i < pvf.size(); i++){
            if (pvf.get(i).getName().equals(chosenItem)){
                typePos = i;
            }
        }
        indicator = getIntent().getCharExtra("indicator", 'F');

        brands = DataProvider.getBrands(indicator);
        final Context context = this;
        adapter = new DataItemAdapter(this, brands);
        rv = findViewById(R.id.BrandList);
        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                    Intent intent = new Intent(context, ChoseFunction.class);
                    intent.putExtra("typePos", typePos);
                    intent.putExtra("brandPosition", pos);
                    intent.putExtra("chosenItem", chosenItem);
                    intent.putExtra("indicator", indicator);
                    startActivity(intent);
                    adapter.notifyDataSetChanged();
            }

        });
    }

    public void GoToAddingScreen(View view) {
        Intent intent = new Intent(this, AddingActivity.class);
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        try {
            adapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        adapter.notifyDataSetChanged();
    }
}
