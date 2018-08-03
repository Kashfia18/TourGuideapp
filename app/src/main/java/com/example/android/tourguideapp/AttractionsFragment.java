/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import junit.framework.Test;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of family vocabulary words.
 */
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_info, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.attraction1, R.string.attraction1_location,
                R.drawable.natural_science));
        places.add(new Place(R.string.attraction2, R.string.attraction2_location,
                R.drawable.art_museum));
        places.add(new Place(R.string.attraction3, R.string.attraction3_location,
                R.drawable.pullen));
        places.add(new Place(R.string.attraction4, R.string.attraction4_location,
                R.drawable.umstead));
        places.add(new Place(R.string.attraction5, R.string.attraction5_location,
                R.drawable.marbles));
        places.add(new Place(R.string.attraction6, R.string.attraction6_location,
                R.drawable.capitol));
        places.add(new Place(R.string.attraction7, R.string.attraction7_location,
                R.drawable.lake_johnson));
        places.add(new Place(R.string.attraction8, R.string.attraction8_location,
                R.drawable.lake_wheeler));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);


        //set a click listener on the list items of the AdapterView (listView).
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the each of list items is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place listItem = places.get(position);
//                object listItem = listView.getItemAtPosition(position);
//                Intent intent = new Intent(getActivity(), Description.class);
//                //Transfer data of the listView from this activity to Now Playing activity,
//                //for playing the song that is clicked on
//                intent.putExtra("Myplace", (Parcelable) listItem);
//                startActivity(intent);
                Fragment attractionsFragment = new AttractionsFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("Myplace", (Parcelable) listItem);
                attractionsFragment.setArguments(bundle);
            }
        });

        return rootView;
    }

}
