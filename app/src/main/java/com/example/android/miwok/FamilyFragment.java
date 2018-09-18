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
public class FamilyFragment extends Fragment {
    private ListClickListener listener = new ListClickListener();


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<Word> familyList = new ArrayList<>(Arrays.asList(
                new Word("father", "әpә", R.drawable.family_father,
                        R.raw.family_father),
                new Word("mother", "әṭa", R.drawable.family_mother,
                        R.raw.family_mother),
                new Word("son", "angsi", R.drawable.family_son,
                        R.raw.family_son),
                new Word("daughter", "tune",R.drawable.family_daughter,
                        R.raw.family_daughter),
                new Word("older brother", "taachi",
                        R.drawable.family_older_brother, R.raw.family_older_brother),
                new Word("younger brother", "chalitti",
                        R.drawable.family_younger_brother, R.raw.family_younger_brother),
                new Word("older sister", "teṭe",
                        R.drawable.family_older_sister, R.raw.family_older_sister),
                new Word("younger sister", "kolliti",
                        R.drawable.family_younger_sister, R.raw.family_younger_sister),
                new Word("grandmother", "ama", R.drawable.family_grandmother,
                        R.raw.family_grandmother),
                new Word("grandfather", "paapa", R.drawable.family_grandfather,
                        R.raw.family_grandfather)
        ));

        WordAdapter familyAdapter = new WordAdapter(getActivity(), familyList, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(familyAdapter);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
