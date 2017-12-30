package com.example.pro4256gb.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList lights = new ArrayList<Light>();
//    final ListAdapter adapter = new CustomeAdapter(this, lights);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lights.add(new Light());
        lights.add(new Light());
        lights.add(new Light());
        lights.add(new Light());
        lights.add(new Light());
        final ListAdapter adapter = new CustomeAdapter(this, lights);

        final ListView elementList = findViewById(R.id.elementList);
        elementList.setAdapter(adapter);



        elementList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        ((Light)lights.get(i)).toggle();
                        ((BaseAdapter)adapter).notifyDataSetChanged();
                    }
                }
        );

        elementList.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        lights.remove(i);
                        ((BaseAdapter)adapter).notifyDataSetChanged();
                        return false;
                    }
                }
        );


        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        lights.add(new Light());
//                        ((BaseAdapter)adapter).notifyDataSetChanged();
                        Intent i = new Intent(MainActivity.this, AddableLights.class);
                        startActivityForResult(i, 1);
                    }
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)

               lights.add((Light)data.getSerializableExtra("result"));
//                ((BaseAdapter)adapter).notifyDataSetChanged();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
