package com.example.project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project.Adapters.PVF_Adapter;
import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    private ArrayList<PVFname> PVF = new ArrayList<>();
    private PVF_Adapter adapter;
    public static String alreadyDeleted = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_lists);
        PVF = DataProvider.pvf;
        adapter = new PVF_Adapter(this, PVF);
        adapter.notifyDataSetChanged();
        ListView rv = findViewById(R.id.ShowPVF);
        rv.setAdapter(adapter);

        final Context context = this;
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                if (!alreadyDeleted.equals(PVF.get(pos).getName())) {
                    Intent intent = new Intent(context, TypeChoosingFunction.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                    adapter.notifyDataSetChanged();

                }
            }

        });
        adapter.notifyDataSetChanged();

    }

    public void onResume() {
        super.onResume();
        try {
            adapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void goToAddType(View view) {
        Intent intent = new Intent(this, TypeAddingActivity.class);
        startActivity(intent);
    }
}
