package com.yasir.languageconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrases extends AppCompatActivity {
     MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mComletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

      final  ArrayList<Word> phr=new ArrayList<Word>();

        phr.add(new Word("come here","yaha aayi ye",R.raw.come));
        phr.add(new Word("sit here","yaha baithiye",R.raw.sit));
        phr.add(new Word("Read this","ye padhiye",R.raw.read));
        phr.add(new Word("how is it?","kaisa laga?",R.raw.how));
        phr.add(new Word("It is good","acha hai",R.raw.itisgood));
        phr.add(new Word("thanks","shukriya",R.raw.thanks));

        WordAdaptor Adapter = new WordAdaptor(this,phr,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word wordpos=phr.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(phrases.this, wordpos.getSoundResource() );
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mComletionListener);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
