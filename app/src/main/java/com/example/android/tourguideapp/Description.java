package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

/**
 * Provides a detailed description of the place from the clicked items of Attractions list.
 */
public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //Along with updating the Android Manifest with the parent Activity this line is added in this activity
        //to enable the arrow in the Action bar as the up arrow. When clicked it will navigate to the parent activity
        //which is the Mainactivity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find the TextViews and ImageView objects in the view hierarchy of the activity_description.xml.
        // These views are declared in the activity_description.xml file.
        ImageView mImageResourceId = findViewById(R.id.place_icon);
        TextView mPlaceName = findViewById(R.id.place_name);
        TextView mPlaceDescription = findViewById(R.id.place_description);

        //collect the intent object
        Intent intent = getIntent();
        // the constructor is called and a Place instance is created
        Place place = intent.getParcelableExtra("Myplace");

        //now collect all values of place class that was converted to a parcel.
        // Also the values are set to the respective views.
        mImageResourceId.setImageResource(place.getImageResourceId());
        mPlaceName.setText(place.getPlaceResourceId());
        mPlaceDescription.setText(place.getDescriptionResourceId());
    }

    //This method is called when the back button is clicked.
    // This way it is guaranteed that the back button will go the previous page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
