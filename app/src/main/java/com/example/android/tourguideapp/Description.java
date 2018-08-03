package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //Along with updating the Android Manifest with the parent Activity this line is added in this activity
        //to enable the arrow in the Action bar as the up arrow. IWhen clicked it will navigate to the parent activity
        //which is the playlists activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find the TextViews and ImageView objects in the view hierarchy of the Activity.
        // These views are declared in the activity_play.xml file.
        ImageView mImageResourceId = findViewById(R.id.place_icon);
        TextView mPlaceName = findViewById(R.id.place_name);
        TextView mPlaceLocation = findViewById(R.id.place_location);

        //collect the intent object
        Intent intent = getIntent();
        // the constructor is called and a Song instance is created
        Place place = intent.getParcelableExtra("Myplace");

        //now collect all values of song class that was converted to a parcel.
        // Also the values are set to the respective views.
        mImageResourceId.setImageResource(place.getImageResourceId());
        mPlaceName.setText(place.getPlaceResourceId());
        mPlaceLocation.setText(place.getLocationResourceId());
    }

}
