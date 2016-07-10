package com.example.klinten.testdd.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.klinten.testdd.R;

import java.util.ArrayList;

/**
 * Created by klinten on 7/10/2016.
 */
public class CustomAdapterOost extends BaseAdapter{
    Context context;
    ArrayList<Locatie> locatie;

    public CustomAdapterOost(Context context, ArrayList<Locatie> locatie) {
        this.context = context;
        this.locatie = locatie;
    }

    @Override
    public int getCount() {
        return locatie.size();
    }

    @Override
    public Object getItem(int position) {
        return locatie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_oost,parent,false);
        }
        return convertView;
    }

}
