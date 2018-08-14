package com.example.android.miwok;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

public class ListClickListener implements AdapterView.OnItemClickListener {
    protected MediaPlayer mediaPlayer;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word currentWord = (Word) parent.getItemAtPosition(position);
        if (currentWord.audioProvided()) {
            mediaPlayer = MediaPlayer.create(view.getContext(), currentWord.getAudioResourceId());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }
}
