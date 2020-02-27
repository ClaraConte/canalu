package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.common.api.Api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class MapsRoutes implements Parcelable , Serializable {

    private int idMapsRoutes;
    private int idEmployees;
    private int idTransports;
    private Transports transports;
    private ArrayList<MapsItems> mapsItems = new ArrayList<>();
    private String mapsRoutesDateCreations;
    private Optional<String> mapsRoutesComments;
    private Optional<String>  mapsRoutesObservations;
    private String mapsRoutesDateStart;
    private Boolean mapsRoutesStatus;

    public MapsRoutes() {
    }

    public MapsRoutes(int idMapsRoutes, int idEmployees, int idTransports, Transports transports, ArrayList<MapsItems> mapsItems, String mapsRoutesDateCreations, Optional<String> mapsRoutesComments, Optional<String> mapsRoutesObservations, String mapsRoutesDateStart, Boolean mapsRoutesStatus) {
        this.idMapsRoutes = idMapsRoutes;
        this.idEmployees = idEmployees;
        this.idTransports = idTransports;
        this.transports = transports;
        this.mapsItems = mapsItems;
        this.mapsRoutesDateCreations = mapsRoutesDateCreations;
        this.mapsRoutesComments = mapsRoutesComments;
        this.mapsRoutesObservations = mapsRoutesObservations;
        this.mapsRoutesDateStart = mapsRoutesDateStart;
        this.mapsRoutesStatus = mapsRoutesStatus;
    }


    protected MapsRoutes(Parcel in) {
        idMapsRoutes = in.readInt();
        idEmployees = in.readInt();
        idTransports = in.readInt();
        transports = in.readParcelable(Transports.class.getClassLoader());
        mapsRoutesDateCreations = in.readString();
        mapsRoutesDateStart = in.readString();
        byte tmpMapsRoutesStatus = in.readByte();
        mapsRoutesStatus = tmpMapsRoutesStatus == 0 ? null : tmpMapsRoutesStatus == 1;
    }

    public static final Creator<MapsRoutes> CREATOR = new Creator<MapsRoutes>() {
        @Override
        public MapsRoutes createFromParcel(Parcel in) {
            return new MapsRoutes(in);
        }

        @Override
        public MapsRoutes[] newArray(int size) {
            return new MapsRoutes[size];
        }
    };

    public int getIdMapsRoutes() {
        return idMapsRoutes;
    }

    public void setIdMapsRoutes(int idMapsRoutes) {
        this.idMapsRoutes = idMapsRoutes;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
    }

    public int getIdTransports() {
        return idTransports;
    }

    public void setIdTransports(int idTransports) {
        this.idTransports = idTransports;
    }

    public Transports getTransports() {
        return transports;
    }

    public void setTransports(Transports transports) {
        this.transports = transports;
    }

    public ArrayList<MapsItems> getMapsItems() {
        return mapsItems;
    }

    public void setMapsItems(ArrayList<MapsItems> mapsItems) {
        this.mapsItems = mapsItems;
    }

    public String getMapsRoutesDateCreations() {
        return mapsRoutesDateCreations;
    }

    public void setMapsRoutesDateCreations(String mapsRoutesDateCreations) {
        this.mapsRoutesDateCreations = mapsRoutesDateCreations;
    }

    public Optional<String> getMapsRoutesComments() {
        return mapsRoutesComments;
    }

    public void setMapsRoutesComments(Optional<String> mapsRoutesComments) {
        this.mapsRoutesComments = mapsRoutesComments;
    }

    public Optional<String> getMapsRoutesObservations() {
        return mapsRoutesObservations;
    }

    public void setMapsRoutesObservations(Optional<String> mapsRoutesObservations) {
        this.mapsRoutesObservations = mapsRoutesObservations;
    }

    public String getMapsRoutesDateStart() {
        return mapsRoutesDateStart;
    }

    public void setMapsRoutesDateStart(String mapsRoutesDateStart) {
        this.mapsRoutesDateStart = mapsRoutesDateStart;
    }

    public Boolean getMapsRoutesStatus() {
        return mapsRoutesStatus;
    }

    public void setMapsRoutesStatus(Boolean mapsRoutesStatus) {
        this.mapsRoutesStatus = mapsRoutesStatus;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMapsRoutes);
        dest.writeInt(idEmployees);
        dest.writeInt(idTransports);
        dest.writeParcelable(transports, flags);
        dest.writeString(mapsRoutesDateCreations);
        dest.writeString(mapsRoutesDateStart);
        dest.writeByte((byte) (mapsRoutesStatus == null ? 0 : mapsRoutesStatus ? 1 : 2));
    }
}
