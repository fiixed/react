package com.fiixed.videodiary;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by abell on 11/24/13.
 */
public class VideoViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview);
        Uri videoUri = Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.shaundub);
        VideoView seenResponse = (VideoView)findViewById(R.id.responsevideoview);
        seenResponse.setVideoURI(videoUri);
        MediaController videoMediaController = new MediaController(this);
        videoMediaController.setAnchorView(seenResponse);
        seenResponse.setMediaController(videoMediaController);
        seenResponse.bringToFront();
        seenResponse.requestFocus();
        seenResponse.start();
        seenResponse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(VideoViewActivity.this, "Going home", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
        });
}
}
