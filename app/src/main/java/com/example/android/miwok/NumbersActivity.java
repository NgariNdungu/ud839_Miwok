package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<>(Arrays.asList("one","two","three", "four",
                "five", "six", "seven", "eight","nine"));
        words.add("ten");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
