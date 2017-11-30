package com.yasir.languageconverter;

/**
 * Created by Moinuddin on 6/12/2017.
 */

public class Word {
    private String hindi, english;
    private int mSoundId;
    private int mImageResouceId = NOIMAGEPOROVIDED;
    private static final int NOIMAGEPOROVIDED = -1;

    public Word(String hin, String eng,int soundid) {
        hindi = hin;
        english = eng;
        mSoundId=soundid;
    }


    public Word(String hin, String eng, int imgResourceId,int soundId) {
        hindi = hin;
        english = eng;
        mImageResouceId = imgResourceId;
        mSoundId=soundId;

    }
    public String getEngTrans() {
        return english;
    }

    public String getHinTans() {
        return hindi;
    }

    public int getImageResource() {
        return mImageResouceId;
    }

    public int getSoundResource() {
        return mSoundId;
    }
    //checks  whether it have oa image
    public boolean hasImage() {
        return mImageResouceId != NOIMAGEPOROVIDED;
    }
}
