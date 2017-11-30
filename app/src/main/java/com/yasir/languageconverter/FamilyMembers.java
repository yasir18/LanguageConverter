package com.yasir.languageconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
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
       final  ArrayList<Word> fam=new ArrayList<Word>();
        fam.add(new Word("mom","maa",R.drawable.family_mother,R.raw.mother));
        fam.add(new Word("dad","baap",R.drawable.family_father,R.raw.dad));
        fam.add(new Word("brother","bhai",R.drawable.family_younger_brother,R.raw.brother));
        fam.add(new Word("sister","behen",R.drawable.family_younger_sister,R.raw.sister));
        fam.add(new Word("grandmother","dadi/nani",R.drawable.family_grandmother,R.raw.grandmom));
        fam.add(new Word("grandfather","dada/nana",R.drawable.family_grandfather,R.raw.granddad));
        fam.add(new Word("Son","Beta",R.drawable.family_son,R.raw.son));
        fam.add(new Word("daughter","beti",R.drawable.family_daughter,R.raw.daughter ));

        WordAdaptor Adapter = new WordAdaptor(this,fam,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word wordpos=fam.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyMembers.this, wordpos.getSoundResource() );
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
