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
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_info, container, false);

        // Create a list of names
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.Shop_1,R.string.shop1_location,
                R.drawable.crabtree));
        places.add(new Place(R.string.shop_2, R.string.shop2_location,
                R.drawable.cary_towne));
        places.add(new Place(R.string.shop_3, R.string.shop3_location,
                R.drawable.north_hills));
        places.add(new Place(R.string.shop_4, R.string.shop4_location,
                R.drawable.triangle_towne));
        places.add(new Place(R.string.shop_5, R.string.shop5_location,
                R.drawable.southpoint));
        places.add(new Place(R.string.shop_6, R.string.shop6_location,
                R.drawable.carolina_place));
        places.add(new Place(R.string.shop_7, R.string.shop7_location,
                R.drawable.northgate));
        places.add(new Place(R.string.shop_8, R.string.shop8_restaurant,
                R.drawable.four_seasons));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_shopping);

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
