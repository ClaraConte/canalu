package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Provinces implements Parcelable, Serializable {

    private int idProvinces;
    private String provincesName;

    public Provinces() {
    }

    public Provinces(int idProvinces, String provincesName) {
        this.idProvinces = idProvinces;
        this.provincesName = provincesName;
    }

    protected Provinces(Parcel in) {
        idProvinces = in.readInt();
        provincesName = in.readString();
    }

    public static final Creator<Provinces> CREATOR = new Creator<Provinces>() {
        @Override
        public Provinces createFromParcel(Parcel in) {
            return new Provinces(in);
        }

        @Override
        public Provinces[] newArray(int size) {
            return new Provinces[size];
        }
    };

    public int getIdProvinces() {
        return idProvinces;
    }

    public void setIdProvinces(int idProvinces) {
        this.idProvinces = idProvinces;
    }

    public String getProvincesName() {
        return provincesName;
    }

    public void setProvincesName(String provincesName) {
        this.provincesName = provincesName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idProvinces);
        parcel.writeString(provincesName);
    }

    @Override
    public String toString() {
        return "Provinces{" +
                "idProvinces=" + idProvinces +
                ", provincesName='" + provincesName + '\'' +
                '}';
    }
}

