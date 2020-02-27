package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Commerces implements Parcelable, Serializable {
    private int idCommerces;
    private String commercesName;
    private String commercesRS;

    public Commerces()  {
    }

    public Commerces(int idCommerces, String commercesName, String commercesRS) {
        this.idCommerces = idCommerces;
        this.commercesName = commercesName;
        this.commercesRS = commercesRS;
    }

    protected Commerces(Parcel in) {
        idCommerces = in.readInt();
        commercesName = in.readString();
        commercesRS = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCommerces);
        dest.writeString(commercesName);
        dest.writeString(commercesRS);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Commerces> CREATOR = new Creator<Commerces>() {
        @Override
        public Commerces createFromParcel(Parcel in) {
            return new Commerces(in);
        }

        @Override
        public Commerces[] newArray(int size) {
            return new Commerces[size];
        }
    };

    public int getIdCommerces() {
        return idCommerces;
    }

    public void setIdCommerces(int idCommerces) {
        this.idCommerces = idCommerces;
    }

    public String getCommercesName() {
        return commercesName;
    }

    public void setCommercesName(String commercesName) {
        this.commercesName = commercesName;
    }

    public String getCommercesRS() {
        return commercesRS;
    }

    public void setCommercesRS(String commercesRS) {
        this.commercesRS = commercesRS;
    }

    @Override
    public String toString() {
        return "Commerces{" +
                "idCommerces=" + idCommerces +
                ", commercesName='" + commercesName + '\'' +
                ", commercesRS='" + commercesRS + '\'' +
                '}';
    }
}
