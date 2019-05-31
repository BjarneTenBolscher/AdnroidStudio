package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.project.Model.DataProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataProvider.getInstance(this);
    }

    public void GoToPVFSelecter(View view) {
        Intent intent = new Intent(this, ChoosingPVF.class);
        startActivity(intent);
    }

    public void GoToShowList(View view) {
        Intent intent = new Intent(this, ShowList.class);
        startActivity(intent);
    }

}
