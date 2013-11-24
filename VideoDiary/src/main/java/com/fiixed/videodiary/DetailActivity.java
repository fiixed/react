package com.fiixed.videodiary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class DetailActivity extends Activity {

    private static final String TAG = "com.fiixed.videodiary.DetailActivity";
    private TextView date;
    private TextView tags;
    private ImageView imageView;
    Camera mCamera;
    MediaRecorder mMediaRecorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Intent i = getIntent();
        String dateString = i.getStringExtra("date");
        String tagString = i.getStringExtra("tags");
        String imageString = i.getStringExtra("image");




        setContentView(R.layout.activity_detail);
        date = (TextView)findViewById(R.id.detailDateTimeTextView);
        date.setText(dateString);
        tags = (TextView)findViewById(R.id.messageTextView);
        tags.setText(tagString);
        imageView = (ImageView)findViewById(R.id.detailVidScreenShotImageView);
        int resID = getResources().getIdentifier(imageString , "drawable", getPackageName());
        imageView.setImageResource(resID);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = openFrontFacingCamera(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    /** iterate through the available cameras and choose the front facing one. */
    private static Camera openFrontFacingCamera()
    {
        int cameraCount = 0;
        Camera cam = null;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        cameraCount = Camera.getNumberOfCameras();
        for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
            Camera.getCameraInfo( camIdx, cameraInfo );
            if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
                try {
                    cam = Camera.open( camIdx );
                } catch (RuntimeException e) {
                    Log.e(TAG, "Camera failed to open: " + e.getLocalizedMessage());
                }
            }
        }

        return cam;
    }
//    private boolean prepareVideoRecorder(){
//
//        mCamera = getCameraInstance();
//        mMediaRecorder = new MediaRecorder();
//
//        // Step 1: Unlock and set camera to MediaRecorder
//        mCamera.unlock();
//        mMediaRecorder.setCamera(mCamera);
//
//        // Step 2: Set sources
//        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
//        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
//
//        // Step 3: Set a CamcorderProfile (requires API Level 8 or higher)
//        mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));
//
//        // Step 4: Set output file
//        mMediaRecorder.setOutputFile(getOutputMediaFile(MEDIA_TYPE_VIDEO).toString());
//
//        // Step 5: Set the preview output
////        mMediaRecorder.setPreviewDisplay(mPreview.getHolder().getSurface());
//
//        // Step 6: Prepare configured MediaRecorder
//        try {
//            mMediaRecorder.prepare();
//        } catch (IllegalStateException e) {
//            Log.d(TAG, "IllegalStateException preparing MediaRecorder: " + e.getMessage());
//            releaseMediaRecorder();
//            return false;
//        } catch (IOException e) {
//            Log.d(TAG, "IOException preparing MediaRecorder: " + e.getMessage());
//            releaseMediaRecorder();
//            return false;
//        }
//        return true;
//    }





}
