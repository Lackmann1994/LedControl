package com.example.pro4256gb.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pro 4 256gb on 12/8/2017.
 */

public class CustomeAdapter extends ArrayAdapter<Light>{


    public CustomeAdapter(@NonNull Context context, ArrayList<Light> lights) {
        super(context, R.layout.custome_list_item, lights);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customeView = inflater.inflate(R.layout.custome_list_item, parent, false);

        Light light = getItem(position);
        TextView name = customeView.findViewById(R.id.name);
        TextView status = customeView.findViewById(R.id.status);
        ImageView bulb = customeView.findViewById(R.id.bulb);
        ImageView power = customeView.findViewById(R.id.power);

        name.setText(light.name);
        status.setText(light.isOn ? "on" : "off");
        bulb.setImageResource(light.isBulb ? R.mipmap.ic_lightbulb_bright : R.mipmap.ic_stripe_bright);
        power.setImageResource(R.mipmap.ic_power);

        return customeView;
    }
}
