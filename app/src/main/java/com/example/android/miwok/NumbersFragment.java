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
public class NumbersFragment extends Fragment {

    private ListClickListener listener = new ListClickListener();


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
