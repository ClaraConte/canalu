package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Optional;

public class MapsItems implements Parcelable, Serializable {

    private int idMapsItems;
    private int idUsers;
    private Users users;
    private int idMapsRoutes;
    private int mapsItemsPriority;
    private Boolean mapsItemsVisited;
    private String mapsItemsDateTime;
    //@Nullable
    private String mapsItemsObservations;

    public MapsItems() {
    }

    public MapsItems(int idMapsItems, int idUsers, Users users, int idMapsRoutes, int mapsItemsPriority, Boolean mapsItemsVisited, String mapsItemsDateTime, String mapsItemsObservations) {
        this.idMapsItems = idMapsItems;
        this.idUsers = idUsers;
        this.users = users;
        this.idMapsRoutes = idMapsRoutes;
        this.mapsItemsPriority = mapsItemsPriority;
        this.mapsItemsVisited = mapsItemsVisited;
        this.mapsItemsDateTime = mapsItemsDateTime;
        this.mapsItemsObservations = mapsItemsObservations;
    }

    protected MapsItems(Parcel in) {
        idMapsItems = in.readInt();
        idUsers = in.readInt();
        users = in.readParcelable(Users.class.getClassLoader());
        idMapsRoutes = in.readInt();
        mapsItemsPriority = in.readInt();
        byte tmpMapsItemsVisited = in.readByte();
        mapsItemsVisited = tmpMapsItemsVisited == 0 ? null : tmpMapsItemsVisited == 1;
        mapsItemsDateTime = in.readString();
        mapsItemsObservations = in.readString();
    }

    public static final Creator<MapsItems> CREATOR = new Creator<MapsItems>() {
        @Override
        public MapsItems createFromParcel(Parcel in) {
            return new MapsItems(in);
        }

        @Override
        public MapsItems[] newArray(int size) {
            return new MapsItems[size];
        }
    };

    public int getIdMapsItems() {
        return idMapsItems;
    }

    public void setIdMapsItems(int idMapsItems) {
        this.idMapsItems = idMapsItems;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getIdMapsRoutes() {
        return idMapsRoutes;
    }

    public void setIdMapsRoutes(int idMapsRoutes) {
        this.idMapsRoutes = idMapsRoutes;
    }

    public int getMapsItemsPriority() {
        return mapsItemsPriority;
    }

    public void setMapsItemsPriority(int mapsItemsPriority) {
        this.mapsItemsPriority = mapsItemsPriority;
    }

    public Boolean getMapsItemsVisited() {
        return mapsItemsVisited;
    }

    public void setMapsItemsVisited(Boolean mapsItemsVisited) {
        this.mapsItemsVisited = mapsItemsVisited;
    }

    public String getMapsItemsDateTime() {
        return mapsItemsDateTime;
    }

    public void setMapsItemsDateTime(String mapsItemsDateTime) {
        this.mapsItemsDateTime = mapsItemsDateTime;
    }

    public String getMapsItemsObservations() {
        return mapsItemsObservations;
    }

    public void setMapsItemsObservations(String mapsItemsObservations) {
        this.mapsItemsObservations = mapsItemsObservations;
    }

    @Override
    public String toString() {
        return "MapsItems{" +
                "idMapsItems=" + idMapsItems +
                ", idUsers=" + idUsers +
                ", users=" + users +
                ", idMapsRoutes=" + idMapsRoutes +
                ", mapsItemsPriority=" + mapsItemsPriority +
                ", mapsItemsVisited=" + mapsItemsVisited +
                ", mapsItemsDateTime='" + mapsItemsDateTime + '\'' +
                ", mapsItemsObservations=" + mapsItemsObservations +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMapsItems);
        dest.writeInt(idUsers);
        dest.writeParcelable(users, flags);
        dest.writeInt(idMapsRoutes);
        dest.writeInt(mapsItemsPriority);
        dest.writeByte((byte) (mapsItemsVisited == null ? 0 : mapsItemsVisited ? 1 : 2));
        dest.writeString(mapsItemsDateTime);
        dest.writeString(mapsItemsObservations);
    }
}
