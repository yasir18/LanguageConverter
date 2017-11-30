package com.yasir.languageconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
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
        final ArrayList<Word> num=new ArrayList<Word>();
        num.add(new Word("one","ek",R.drawable.number_one,R.raw.one));
        num.add(new Word("two","do",R.drawable.number_two,R.raw.two));
        num.add(new Word("three","teen",R.drawable.number_three,R.raw.three));
        num.add(new Word("four","chaar",R.drawable.number_four,R.raw.four));
        num.add(new Word("five","paanch",R.drawable.number_five,R.raw.five));
        num.add(new Word("six","chey",R.drawable.number_six,R.raw.six));
        num.add(new Word("seven","saat",R.drawable.number_seven,R.raw.seven ));
        num.add(new Word("eight","aat",R.drawable.number_eight,R.raw.eight ));
        num.add(new Word("nine","nau",R.drawable.number_nine,R.raw.nine));



        WordAdaptor Adapter = new WordAdaptor(this,num,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word wordpos=num.get(position);
               releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(Numbers.this, wordpos.getSoundResource() );
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
