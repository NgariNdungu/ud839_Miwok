package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    private ListClickListener listener = new ListClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>(Arrays.asList(
                new Word("one","lutti", R.drawable.number_one,
                        R.raw.number_one),
                new Word("two","otiiko", R.drawable.number_two,
                        R.raw.number_two),
                new Word("three","tolookosu", R.drawable.number_three,
                        R.raw.number_three),
                new Word("four","oyyisa", R.drawable.number_four,
                        R.raw.number_four),
                new Word("five","massokka", R.drawable.number_five,
                        R.raw.number_five),
                new Word("six","temmokka", R.drawable.number_six,
                        R.raw.number_six),
                new Word("seven","kenekaku", R.drawable.number_seven,
                        R.raw.number_seven),
                new Word("eight","kawinta", R.drawable.number_eight,
                        R.raw.number_eight),
                new Word("nine","wo’e", R.drawable.number_nine,
                        R.raw.number_nine),
                new Word("ten","na’aacha", R.drawable.number_ten,
                        R.raw.number_ten)
                ));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(itemsAdapter);

        // Add up arrow
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
