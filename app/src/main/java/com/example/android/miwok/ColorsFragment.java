package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {
    private ListClickListener listener = new ListClickListener();


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

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

        WordAdapter colorsAdapter = new WordAdapter(getActivity(), colorsList, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(colorsAdapter);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
