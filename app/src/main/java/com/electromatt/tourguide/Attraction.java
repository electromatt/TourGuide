package com.electromatt.tourguide;

public class Attraction {

    private int mDefaultId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Attraction(int defaultId) {
        mDefaultId = defaultId;
    }
    public Attraction(int defaultId, int imageResourceId) {
        mDefaultId = defaultId;
        mImageResourceId = imageResourceId;
    }
    public int getDefaultId() {
        return mDefaultId;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}