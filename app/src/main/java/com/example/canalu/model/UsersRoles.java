package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class UsersRoles implements  Serializable, Parcelable {
    private int IdUsersRoles;
    private String UsersRolesName;

    public UsersRoles() {
    }

    public UsersRoles(int idUsersRoles, String usersRolesName) {
        IdUsersRoles = idUsersRoles;
        UsersRolesName = usersRolesName;
    }

    protected UsersRoles(Parcel in) {
        IdUsersRoles = in.readInt();
        UsersRolesName = in.readString();
    }

    public static final Creator<UsersRoles> CREATOR = new Creator<UsersRoles>() {
        @Override
        public UsersRoles createFromParcel(Parcel in) {
            return new UsersRoles(in);
        }

        @Override
        public UsersRoles[] newArray(int size) {
            return new UsersRoles[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(IdUsersRoles);
        dest.writeString(UsersRolesName);
    }

    public int getIdUsersRoles() {
        return IdUsersRoles;
    }

    public void setIdUsersRoles(int idUsersRoles) {
        IdUsersRoles = idUsersRoles;
    }

    public String getUsersRolesName() {
        return UsersRolesName;
    }

    public void setUsersRolesName(String usersRolesName) {
        UsersRolesName = usersRolesName;
    }

    @Override
    public String toString() {
        return "UsersRoles{" +
                "IdUsersRoles=" + IdUsersRoles +
                ", UsersRolesName='" + UsersRolesName + '\'' +
                '}';
    }
}
