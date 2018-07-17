package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorsList = new ArrayList<>(Arrays.asList(
           new Word("red", "weṭeṭṭi"),
           new Word("green", "chokokki"),
           new Word("brown", "ṭakaakki"),
           new Word("gray", "ṭopoppi"),
           new Word("black", "kululli"),
           new Word("white", "kelelli"),
           new Word("dusty yellow", "ṭopiisә"),
           new Word("mustard yellow", "chiwiiṭә")
        ));

        WordAdapter colorsAdapter = new WordAdapter(this, colorsList);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);
    }
}
