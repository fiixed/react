package com.fiixed.react;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends Activity {

    private static final String TAG = "com.fiixed.videodiary.DetailActivity";
    private TextView date;
    private TextView tags;
    private ImageView imageView;
    Camera mCamera;
    MediaRecorder mMediaRecorder;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;


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
//        prepareVideoRecorder();
//        mMediaRecorder.setMaxDuration(15000);
//        mMediaRecorder.start();
//        mMediaRecorder.stop();
//        mMediaRecorder.release();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }

//    /** A safe way to get an instance of the Camera object. */
//    public static Camera getCameraInstance(){
//        Camera c = null;
//        try {
//            c = openFrontFacingCamera(); // attempt to get a Camera instance
//        }
//        catch (Exception e){
//            // Camera is not available (in use or does not exist)
//        }
//        return c; // returns null if camera is unavailable
//    }
//
//    /** iterate through the available cameras and choose the front facing one. */
//    private static Camera openFrontFacingCamera()
//    {
//        int cameraCount = 0;
//        Camera cam = null;
//        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
//        cameraCount = Camera.getNumberOfCameras();
//        for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
//            Camera.getCameraInfo( camIdx, cameraInfo );
//            if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
//                try {
//                    cam = Camera.open( camIdx );
//                } catch (RuntimeException e) {
//                    Log.e(TAG, "Camera failed to open: " + e.getLocalizedMessage());
//                }
//            }
//        }
//
//        return cam;
//    }
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
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        releaseMediaRecorder();       // if you are using MediaRecorder, release it first
//        releaseCamera();              // release the camera immediately on pause event
//    }
//
//    private void releaseMediaRecorder(){
//        if (mMediaRecorder != null) {
//            mMediaRecorder.reset();   // clear recorder configuration
//            mMediaRecorder.release(); // release the recorder object
//            mMediaRecorder = null;
//            mCamera.lock();           // lock camera for later use
//        }
//    }
//
//    private void releaseCamera(){
//        if (mCamera != null){
//            mCamera.release();        // release the camera for other applications
//            mCamera = null;
//        }
//    }
//
//    /** Create a file Uri for saving an image or video */
//    private static Uri getOutputMediaFileUri(int type){
//        return Uri.fromFile(getOutputMediaFile(type));
//    }
//
//    /** Create a File for saving an image or video */
//    private static File getOutputMediaFile(int type){
//        // To be safe, you should check that the SDCard is mounted
//        // using Environment.getExternalStorageState() before doing this.
//
//        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), "MyCameraApp");
//        // This location works best if you want the created images to be shared
//        // between applications and persist after your app has been uninstalled.
//
//        // Create the storage directory if it does not exist
//        if (! mediaStorageDir.exists()){
//            if (! mediaStorageDir.mkdirs()){
//                Log.d("MyCameraApp", "failed to create directory");
//                return null;
//            }
//        }
//
//        // Create a media file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File mediaFile;
//        if (type == MEDIA_TYPE_IMAGE){
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
//                    "IMG_"+ timeStamp + ".jpg");
//        } else if(type == MEDIA_TYPE_VIDEO) {
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
//                    "VID_"+ timeStamp + ".mp4");
//        } else {
//            return null;
//        }
//
//        return mediaFile;
//    }

}
