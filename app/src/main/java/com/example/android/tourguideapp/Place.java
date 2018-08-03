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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Place} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class Place implements Parcelable{

    /** String resource ID for the default translation of the word */
    private int mPlaceResourceId;

    /** String resource ID for the Miwok translation of the word */
    private int mLocationResourceId;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /**
     * Create a new Place object.
     *
     * @param placeResourceId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param locationResourceId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Place(int placeResourceId, int locationResourceId, int imageResourceId) {
        mPlaceResourceId = placeResourceId;
        mLocationResourceId = locationResourceId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getPlaceResourceId() {
        return mPlaceResourceId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getLocationResourceId() {
        return mLocationResourceId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int describeContents() {
        return 0;
    }

    //write object values to parcel for storage. In this method we write all the properties of Song object
    //to parcel in preparation of transfer. write method is used to add each of the properties.
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPlaceResourceId);
        dest.writeInt(mLocationResourceId);
        dest.writeInt(mImageResourceId);

    }

    //constructor used for parcel. Called in the receiving activity, where we will collect values.
    public Place(Parcel parcel) {
        mPlaceResourceId = parcel.readInt();
        mLocationResourceId = parcel.readInt();
        mImageResourceId = parcel.readInt();
    }

    //used when un-parceling our parcel (creating the object)
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {

        @Override
        public Place createFromParcel(Parcel parcel) {
            return new Place(parcel);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[0];
        }
    };

}