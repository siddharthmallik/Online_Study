package com.example.onlinestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Introduction to Android");
        list.add("Kotlin");
        list.add("Android Testing");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if ( position == 0 ){
                    startActivity(new Intent(ServicesActivity.this,introductionAndroid.class));
                    Toast.makeText(ServicesActivity.this, "You are opening Introduction to Java", Toast.LENGTH_LONG).show();
                }

                else if ( position == 1) {
                    startActivity(new Intent(ServicesActivity.this,kotlin.class));
                    Toast.makeText(ServicesActivity.this,"Inheritance", Toast.LENGTH_LONG).show();

                }

                else {
                    startActivity(new Intent(ServicesActivity.this,androidTesting.class));
                    Toast.makeText(ServicesActivity.this,"Interface",Toast.LENGTH_LONG).show();

                }


            }
        });


    }
}