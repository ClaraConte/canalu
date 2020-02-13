package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Locations implements Parcelable {

    private int idLocations;
    private int idProvinces;
    private Provinces provinces;
    private String locationsName;

    public Locations() {
    }

    public Locations(int idLocations, int idProvinces, Provinces provinces, String locationsName) {
        this.idLocations = idLocations;
        this.idProvinces = idProvinces;
        this.provinces = provinces;
        this.locationsName = locationsName;
    }

    protected Locations(Parcel in) {
        idLocations = in.readInt();
        idProvinces = in.readInt();
        locationsName = in.readString();
    }

    public static final Creator<Locations> CREATOR = new Creator<Locations>() {
        @Override
        public Locations createFromParcel(Parcel in) {
            return new Locations(in);
        }

        @Override
        public Locations[] newArray(int size) {
            return new Locations[size];
        }
    };

    public int getIdLocations() {
        return idLocations;
    }

    public void setIdLocations(int idLocations) {
        this.idLocations = idLocations;
    }

    public int getIdProvinces() {
        return idProvinces;
    }

    public void setIdProvinces(int idProvinces) {
        this.idProvinces = idProvinces;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public String getLocationsName() {
        return locationsName;
    }

    public void setLocationsName(String locationsName) {
        this.locationsName = locationsName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idLocations);
        parcel.writeInt(idProvinces);
        parcel.writeString(locationsName);
    }
}
