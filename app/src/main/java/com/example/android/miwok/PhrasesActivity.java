package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesList = new ArrayList<>(Arrays.asList(
                new Word("Where are you going?", "minto wuksus"),
                new Word("What is your name?", "tinnә oyaase'nә"),
                new Word("My name is...", "oyaaset..."),
                new Word("How are you feeling?", "michәksәs?"),
                new Word("I’m feeling good.", "kuchi achit"),
                new Word("Are you coming?", "әәnәs'aa?"),
                new Word("Yes, I’m coming.", "hәә’ әәnәm"),
                new Word("I’m coming.", "әәnәm"),
                new Word("Let’s go.", "yoowutis"),
                new Word("Come here.", "әnni'nem")
        ));

        WordAdapter phrasesAdapter = new WordAdapter(this, phrasesList);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(phrasesAdapter);
    }
}
