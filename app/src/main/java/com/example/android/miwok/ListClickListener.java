package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class ListClickListener implements AdapterView.OnItemClickListener {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener audioFocusListener = new AudioManager.
            OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (mediaPlayer != null) {
                if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    mediaPlayer.start();

                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    mediaPlayer.release();
                    audioManager.abandonAudioFocus(this);
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                        focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mediaPlayer.pause();
                    // resume play at start of word
                    mediaPlayer.seekTo(0);
                }
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // get the Word object at the clicked position
        Word currentWord = (Word) parent.getItemAtPosition(position);
        // obtain instance of the audio manager service
        audioManager = (AudioManager) view.getContext().getSystemService(Context.AUDIO_SERVICE);

        if (currentWord.audioProvided()) {
            mediaPlayer = MediaPlayer.create(view.getContext(), currentWord.getAudioResourceId());
            // request audio focus
            int focus = audioManager.requestAudioFocus(audioFocusListener, AudioManager.STREAM_MUSIC,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (focus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // play audio if focus is granted
                mediaPlayer.start();
            }
            // clean up resources after audio file is played
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseResources(mp);
                }
            });
        }
    }

    /*
    * reset the media player and release audio focus
    */
    protected void releaseResources(@Nullable MediaPlayer mp) {
        // HC SVNT DRACONES
        if (mp != null) {
            // called by oncompletionlistener
            mp.release();
        } else if (mediaPlayer != null) {
            // called by activity onstop
            mediaPlayer.release();
        }
        // clear audio focus
        if (audioManager != null) {
            audioManager.abandonAudioFocus(audioFocusListener);
            Log.i("ListClickListener", "Audio focus abandoned!!!!");
        }
    }
}
