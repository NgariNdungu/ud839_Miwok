package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
    private ListClickListener listener = new ListClickListener();

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container,false);

        ArrayList<Word> phrasesList = new ArrayList<>(Arrays.asList(
                new Word("Where are you going?", "minto wuksus",
                        R.raw.phrase_where_are_you_going),
                new Word("What is your name?", "tinnә oyaase'nә",
                        R.raw.phrase_what_is_your_name),
                new Word("My name is...", "oyaaset...",
                        R.raw.phrase_my_name_is),
                new Word("How are you feeling?", "michәksәs?",
                        R.raw.phrase_how_are_you_feeling),
                new Word("I’m feeling good.", "kuchi achit",
                        R.raw.phrase_im_feeling_good),
                new Word("Are you coming?", "әәnәs'aa?",
                        R.raw.phrase_are_you_coming),
                new Word("Yes, I’m coming.", "hәә’ әәnәm",
                        R.raw.phrase_yes_im_coming),
                new Word("I’m coming.", "әәnәm",
                        R.raw.phrase_im_coming),
                new Word("Let’s go.", "yoowutis",
                        R.raw.phrase_lets_go),
                new Word("Come here.", "әnni'nem",
                        R.raw.phrase_come_here)
        ));

        WordAdapter phrasesAdapter = new WordAdapter(getActivity(), phrasesList, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(phrasesAdapter);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
