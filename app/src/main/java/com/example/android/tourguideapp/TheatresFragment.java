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


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of phrases.
 */
public class TheatresFragment extends Fragment {

    public TheatresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_info, container, false);

        // Create a list of names
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.theatre_1, R.string.theatre1_location, R.drawable.mission_valley));
        places.add(new Place(R.string.theatre_2, R.string.theatre2_location, R.drawable.imax_marbles));
        places.add(new Place(R.string.theatre_3, R.string.theatre3_location, R.drawable.blueridge));
        places.add(new Place(R.string.theatre_4, R.string.theatre4_location, R.drawable.regal_north_hills));
        places.add(new Place(R.string.theatre_5, R.string.theatre5_location, R.drawable.rialto));
        places.add(new Place(R.string.theatre_6, R.string.theatre6_location, R.drawable.raleigh_grande));
        places.add(new Place(R.string.theatre_7, R.string.theatre7_location, R.drawable.six_forks_cinemas));
        places.add(new Place(R.string.theatre_8, R.string.theatre8_location, R.drawable.marquee));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_theatres);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

}
