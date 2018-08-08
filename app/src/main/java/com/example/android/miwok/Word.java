package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_RESOURCE_PROVIDED;
    private static final int NO_RESOURCE_PROVIDED = -1;
    private int mAudioResourceId = NO_RESOURCE_PROVIDED;

    public Word(String defaultTranslation, String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    /*
    * Constructor for phrases which lack an image
    */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    /*
    * Constructor for all other word lists
    */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean imageProvided() {
        return mImageResourceId != NO_RESOURCE_PROVIDED;
    }

    public boolean audioProvided() {
        return mAudioResourceId != NO_RESOURCE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
