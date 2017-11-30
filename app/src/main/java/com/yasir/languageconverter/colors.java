package com.yasir.languageconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colors extends AppCompatActivity {
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
        final ArrayList<Word> col=new ArrayList<Word>();

        col.add(new Word("black","kaala",R.drawable.color_black,R.raw.black));
        col.add(new Word("yellow","peela",R.drawable.color_mustard_yellow,R.raw.yellow));
        col.add(new Word("red","laal",R.drawable.color_red,R.raw.red));
        col.add(new Word("white","safaed",R.drawable.color_white,R.raw.white));
        col.add(new Word("brown","chocolaty",R.drawable.color_brown,R.raw.brown));
        col.add(new Word("green","hara",R.drawable.color_green,R.raw.green ));

        WordAdaptor Adapter = new WordAdaptor(this,col,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word wordpos=col.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(colors.this, wordpos.getSoundResource() );
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
