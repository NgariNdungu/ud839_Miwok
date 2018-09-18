package com.example.android.miwok;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    private ListClickListener listener = new ListClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // add phrases fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PhrasesFragment())
                .commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
