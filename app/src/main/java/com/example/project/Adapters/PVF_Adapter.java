package com.example.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.project.Model.DataProvider;
import com.example.project.Model.PVFname;
import com.example.project.onDraw.CountingView;
import com.example.project.R;

import java.util.List;


public class PVF_Adapter extends ArrayAdapter {

    List<PVFname> pvfNames;
    LayoutInflater layoutInflater;
    TextView nameView;

    public PVF_Adapter(Context context, List<PVFname> objects) {
        super(context, R.layout.pvf_list_view, objects);
        pvfNames = objects;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.pvf_list_view, parent, false);
        }
        CountingView countingView = convertView.findViewById(R.id.countingView);
        nameView = convertView.findViewById(R.id.name);

        final String pvfName = pvfNames.get(position).getName();

        nameView.setText(pvfName);
        countingView.counting(DataProvider.pvf, pvfName);
        return convertView;
    }
}
