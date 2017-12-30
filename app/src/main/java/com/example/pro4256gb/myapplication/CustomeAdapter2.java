package com.example.pro4256gb.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pro 4 256gb on 12/8/2017.
 */

public class CustomeAdapter2 extends ArrayAdapter<Light>{


    public CustomeAdapter2(@NonNull Context context, ArrayList<Light> lights) {
        super(context, R.layout.custome_list_item2, lights);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customeView = inflater.inflate(R.layout.custome_list_item2, parent, false);

        Light light = getItem(position);
        TextView macAddress = customeView.findViewById(R.id.macAddress);
        TextView type = customeView.findViewById(R.id.type);
        ImageView bulb = customeView.findViewById(R.id.bulb);

        macAddress.setText(light.macAddress);
        type.setText(light.type);
        bulb.setImageResource(light.isBulb ? R.mipmap.ic_lightbulb_bright : R.mipmap.ic_stripe_bright);

        return customeView;
    }
}
