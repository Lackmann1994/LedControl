package com.example.pro4256gb.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AddableLights extends Activity {


    ArrayList lights = new ArrayList<Light>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addable_lights);


        lights.add(new Light());
        lights.add(new Light());
        lights.add(new Light("name", "RGB", false));
        lights.add(new Light());
        lights.add(new Light());
        final ListAdapter adapter = new CustomeAdapter2(this, lights);

        final ListView elementList = findViewById(R.id.elementList);
        elementList.setAdapter(adapter);


        elementList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddableLights.this);
                        builder.setTitle("Title");
                        final EditText input = new EditText(AddableLights.this);
                        input.setInputType(InputType.TYPE_CLASS_TEXT);
                        builder.setView(input);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((Light) lights.get(i)).setName(input.getText().toString());
                                Intent returnIntent = new Intent();
                                returnIntent.putExtra("result", (Light) lights.get(i));
                                setResult(Activity.RESULT_OK, returnIntent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();


//                        ((Light) lights.get(i)).setName("asdf");
//                        Intent returnIntent = new Intent();
//                        returnIntent.putExtra("result", (Light) lights.get(i));
//                        setResult(Activity.RESULT_OK, returnIntent);
//                        finish();

                    }
                }
        );


    }

}
