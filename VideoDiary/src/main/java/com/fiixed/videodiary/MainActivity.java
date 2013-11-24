package com.fiixed.videodiary;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends Activity {

    private static final String TAG = "com.fiixed.videodiary.MainActivity";
    private static final String TAG1 = "com.fiixed.videodiary.MainActivity";
    private static final String TAG2 = "com.fiixed.videodiary.MainActivity";
    private static final String TAG3 = "com.fiixed.videodiary.MainActivity";

    private static final int VIDEO_CAPTURE = 101;
    private Uri fileUri;
//    private ImageView mVidScreenshot;
    private ListView mListView;


    Video[] myVideosArray = new Video[]
            {
                    new Video("Wednesday 15th Nov, 2013", "hey man whats up?", "image01"),
                    new Video("Tuesday 14th Nov, 2013", "Call me I NEED you", "image02"),
                    new Video("Monday 13th Nov, 2013", "been trying to reach you?", "image03"),

                    new Video("Tuesday 14th Nov, 2013", "Andrew I'm pregnant with your baby!  please call me!", "image05"),
                    new Video("Tuesday 14th Nov, 2013", "I miss your smile...!", "image06"),
                    new Video("Tuesday 14th Nov, 2013", "hello?", "image07"),
                    new Video("Tuesday 14th Nov, 2013", "what you doing?", "image02"),
                    new Video("Tuesday 14th Nov, 2013", "I'm bored, call me", "image02"),
                    new Video("Tuesday 14th Nov, 2013", "OMG IM OTW", "image02"),
                    new Video("Tuesday 14th Nov, 2013", "why dont you ever call me?", "image02"),
                    new Video("Tuesday 14th Nov, 2013", "Open the door", "image02"),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        VideoAdapter videoAdapter = new VideoAdapter(getApplicationContext(), R.layout.row, myVideosArray);

        mListView = (ListView) findViewById(R.id.videoListView);

        if (mListView != null) {
            mListView.setAdapter(videoAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a,
                                    View v, int position, long id) {
                Video video = (Video) a.getItemAtPosition(position);
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("date", video.mDate);
                intent.putExtra("tags", video.mTags);
                intent.putExtra("image", video.mNameOfImage);
                startActivity(intent);
            }
        });

//        mVidScreenshot = (ImageView) findViewById(R.id.vidImageView);
//        mVidScreenshot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
//
//                startActivity(intent);
//            }
//        });


    }

    public void startRecording() {
        File mediaFile = new
                File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myvideo.mp4");

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        fileUri = Uri.fromFile(mediaFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, VIDEO_CAPTURE);
    }



    private boolean hasCamera() {
        if (getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FRONT)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_video:
                startRecording();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSearch() {
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Video has been saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
    }


}
