package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Commerces implements Parcelable {
    private int idCommerces;
    private String CommercesName;
    private String CommercesRs;

    public Commerces()  {
    }

    public Commerces(int idCommerces, String commercesName, String commercesRs) {
        this.idCommerces = idCommerces;
        CommercesName = commercesName;
        CommercesRs = commercesRs;
    }

    protected Commerces(Parcel in) {
        idCommerces = in.readInt();
        CommercesName = in.readString();
        CommercesRs = in.readString();
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
        return CommercesName;
    }

    public void setCommercesName(String commercesName) {
        CommercesName = commercesName;
    }

    public String getCommercesRs() {
        return CommercesRs;
    }

    public void setCommercesRs(String commercesRs) {
        CommercesRs = commercesRs;
    }

    @Override
    public String toString() {
        return "Commerces{" +
                "idCommerces=" + idCommerces +
                ", CommercesName='" + CommercesName + '\'' +
                ", CommercesRs='" + CommercesRs + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idCommerces);
        parcel.writeString(CommercesName);
        parcel.writeString(CommercesRs);
    }
}
