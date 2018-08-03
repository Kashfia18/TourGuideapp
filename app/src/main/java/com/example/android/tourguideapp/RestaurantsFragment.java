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


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of places that are restaurants.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_info, container, false);

        // Create a list of restaurant places.
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.restaurant_1, R.string.restaurant1_location,
                R.drawable.sitti));
        places.add(new Place(R.string.restaurant_2, R.string.restaurant2_location,
                R.drawable.buxton));
        places.add(new Place(R.string.restaurant_3, R.string.restaurant3_location,
                R.drawable.cafe_tiramisu));
        places.add(new Place(R.string.restaurant_4, R.string.restaurant4_location,
                R.drawable.lynnwood_grill));
        places.add(new Place(R.string.restaurant_5, R.string.restaurant5_location,
                R.drawable.peking_garden));
        places.add(new Place(R.string.restaurant_6, R.string.restaurant6_location,
                R.drawable.indio));
        places.add(new Place(R.string.restaurant_7, R.string.restaurant7_location,
                R.drawable.biryani_max));
        places.add(new Place(R.string.restaurant_8, R.string.restaurant8_location,
                R.drawable.azitra));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurant);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list_of_info.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        return rootView;

        }
}

