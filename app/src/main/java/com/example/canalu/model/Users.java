package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Users implements Parcelable {

    private int idUsers;
    private String usersFirstName;
    private String usersLastName;
    private Long usersDni;
    private int idAddress;
    private String address;
    private String usersPhone;
    private String usersEmail;

    @SerializedName("usersBirthDay")
    private String usersBirthDay;

    public Users(int idUsers, String usersFirstName, String usersLastName, Long usersDni, int idAddress, String address, String usersPhone, String usersEmail, String usersBirthDay) {
        this.idUsers = idUsers;
        this.usersFirstName = usersFirstName;
        this.usersLastName = usersLastName;
        this.usersDni = usersDni;
        this.idAddress = idAddress;
        this.address = address;
        this.usersPhone = usersPhone;
        this.usersEmail = usersEmail;
        this.usersBirthDay = usersBirthDay;
    }

    public Users() {
    }

    protected Users(Parcel in) {
        idUsers = in.readInt();
        usersFirstName = in.readString();
        usersLastName = in.readString();
        if (in.readByte() == 0) {
            usersDni = null;
        } else {
            usersDni = in.readLong();
        }
        idAddress = in.readInt();
        address = in.readString();
        usersPhone = in.readString();
        usersEmail = in.readString();
        usersBirthDay = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getUsersFirstName() {
        return usersFirstName;
    }

    public void setUsersFirstName(String usersFirstName) {
        this.usersFirstName = usersFirstName;
    }

    public String getUsersLastName() {
        return usersLastName;
    }

    public void setUsersLastName(String usersLastName) {
        this.usersLastName = usersLastName;
    }

    public Long getUsersDni() {
        return usersDni;
    }

    public void setUsersDni(Long usersDni) {
        this.usersDni = usersDni;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsersPhone() {
        return usersPhone;
    }

    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersBirthDay() {
        return usersBirthDay;
    }

    public void setUsersBirthDay(String usersBirthDay) {
        this.usersBirthDay = usersBirthDay;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", usersFirstName='" + usersFirstName + '\'' +
                ", usersLastName='" + usersLastName + '\'' +
                ", usersDni=" + usersDni +
                ", idAddress=" + idAddress +
                ", address='" + address + '\'' +
                ", usersPhone='" + usersPhone + '\'' +
                ", usersEmail='" + usersEmail + '\'' +
                ", usersBirthDay=" + usersBirthDay +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idUsers);
        parcel.writeString(usersFirstName);
        parcel.writeString(usersLastName);
        if (usersDni == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(usersDni);
        }
        parcel.writeInt(idAddress);
        parcel.writeString(address);
        parcel.writeString(usersPhone);
        parcel.writeString(usersEmail);
        parcel.writeString(usersBirthDay);
    }
}
