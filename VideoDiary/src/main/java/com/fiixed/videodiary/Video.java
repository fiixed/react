package com.fiixed.videodiary;

import java.util.Date;

/**
 * Created by abell on 11/18/13.
 */
public class Video {
    public String mDate;
    public String mName;
    public String mTags;
    public String mNameOfImage;

    public Video (String mDate, String name, String mTags,String mNameOfImage ){

        this.mDate = mDate;
        this.mName = name;
        this.mTags = mTags;
        this.mNameOfImage = mNameOfImage;

    }
}
