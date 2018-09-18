package com.example.android.miwok;

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
        setContentView(R.layout.activity_category);

        // add colors fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new ColorsFragment())
                .commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listener.releaseResources(null);
    }
}
