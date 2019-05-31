package com.example.project.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.project.Model.Brand;
import com.example.project.Model.DataProvider;
import com.example.project.R;

import java.util.List;

public class DataItemAdapter extends ArrayAdapter {

    private List<Brand> mItems;
    private TextView tvName;
    private TextView numberView;
    private LayoutInflater layoutInflater;

    public DataItemAdapter(Context context, List<Brand> items) {
        super(context, R.layout.pvf_list_view, items);
        this.mItems = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        try{

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.brand_list_view, parent, false);
        }

        tvName = convertView.findViewById(R.id.Name);
        numberView = convertView.findViewById(R.id.biggest);

        Brand item = mItems.get(position);
        tvName.setText(item.getItemName());
        numberView.setText(Double.toString(item.getCosts()));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getCause());
        }

        return convertView;
    }


}
