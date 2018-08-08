package com.example.android.miwok;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

public class ListClickListener implements AdapterView.OnItemClickListener {
    private MediaPlayer mediaPlayer;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word currentWord = (Word) parent.getItemAtPosition(position);
        if (currentWord.audioProvided()) {
            mediaPlayer = MediaPlayer.create(parent.getContext(), currentWord.getAudioResourceId());
            mediaPlayer.start();
        }
    }
}
