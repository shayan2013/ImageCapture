package com.example.shayan2013.imagecapture;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.content.pm.PackageInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;


public class MainActivity extends ActionBarActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView shayansImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.myButton);
        shayansImageView = (ImageView) findViewById(R.id.shayansImageView);

        //Disable the Button if the user has no camera
        if (!hasCamera())
            myButton.setEnabled(false);
    }

        //check if the user has a camera
        private boolean hasCamera(){
            return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
        }


        //Launching camera
        public void launchCamera(View view){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //take a picture and pass results along to onActivityResult
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

    //If you want to return the image taken


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            shayansImageView.setImageBitmap(photo);
        }
    }
}
