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

public class FreeTrialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_trial);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Introduction to Java");
        list.add("Inheritance");
        list.add("Interface");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if ( position == 0 ){
                    startActivity(new Intent(FreeTrialActivity.this,introductionjava.class));
                    Toast.makeText(FreeTrialActivity.this, "You are opening Introduction to Java", Toast.LENGTH_LONG).show();
                }

                else if ( position == 1) {
                    startActivity(new Intent(FreeTrialActivity.this,inheritance.class));
                    Toast.makeText(FreeTrialActivity.this,"Inheritance", Toast.LENGTH_LONG).show();

                }

                else {
                    startActivity(new Intent(FreeTrialActivity.this,interfacejava.class));
                    Toast.makeText(FreeTrialActivity.this,"Interface",Toast.LENGTH_LONG).show();

                }


            }
        });







    }
}