package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    private ListClickListener listener = new ListClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorsList = new ArrayList<>(Arrays.asList(
           new Word("red", "weṭeṭṭi", R.drawable.color_red,
                   R.raw.color_red),
           new Word("green", "chokokki", R.drawable.color_green,
                   R.raw.color_green),
           new Word("brown", "ṭakaakki", R.drawable.color_brown,
                   R.raw.color_brown),
           new Word("gray", "ṭopoppi", R.drawable.color_gray,
                   R.raw.color_gray),
           new Word("black", "kululli", R.drawable.color_black,
                   R.raw.color_black),
           new Word("white", "kelelli", R.drawable.color_white,
                   R.raw.color_white),
           new Word("dusty yellow", "ṭopiisә",
                   R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
           new Word("mustard yellow", "chiwiiṭә",
                   R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow)
        ));

        WordAdapter colorsAdapter = new WordAdapter(this, colorsList, R.color.category_colors);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(colorsAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        listener.mediaPlayer.release();
    }
}
