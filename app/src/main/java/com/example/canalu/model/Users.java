package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Parcelable, Serializable {

    private int idUsers;
    private String usersFirstName;
    private String usersLastName;
    private int usersDni;
    private String usersPhone;
    private String usersEmail;
    private String usersBirthDay;
    private ArrayList<Address> address = new ArrayList<>();
    private Employees employees;

    public Users() {
    }

    public Users(int idUsers, String usersFirstName, String usersLastName, int usersDni, String usersPhone, String usersEmail, String usersBirthDay, ArrayList<Address> address, Employees employees) {
        this.idUsers = idUsers;
        this.usersFirstName = usersFirstName;
        this.usersLastName = usersLastName;
        this.usersDni = usersDni;
        this.usersPhone = usersPhone;
        this.usersEmail = usersEmail;
        this.usersBirthDay = usersBirthDay;
        this.address = address;
        this.employees = employees;
    }

    protected Users(Parcel in) {
        idUsers = in.readInt();
        usersFirstName = in.readString();
        usersLastName = in.readString();
        usersDni = in.readInt();
        usersPhone = in.readString();
        usersEmail = in.readString();
        usersBirthDay = in.readString();
        address = in.createTypedArrayList(Address.CREATOR);
        employees = in.readParcelable(Employees.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idUsers);
        dest.writeString(usersFirstName);
        dest.writeString(usersLastName);
        dest.writeInt(usersDni);
        dest.writeString(usersPhone);
        dest.writeString(usersEmail);
        dest.writeString(usersBirthDay);
        dest.writeTypedList(address);
        dest.writeParcelable(employees, flags);
    }

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

    public int getUsersDni() {
        return usersDni;
    }

    public void setUsersDni(int usersDni) {
        this.usersDni = usersDni;
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

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public static Creator<Users> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", usersFirstName='" + usersFirstName + '\'' +
                ", usersLastName='" + usersLastName + '\'' +
                ", usersDni=" + usersDni +
                ", usersPhone='" + usersPhone + '\'' +
                ", usersEmail='" + usersEmail + '\'' +
                ", usersBirthDay='" + usersBirthDay + '\'' +
                ", address=" + address +
                ", employees=" + employees +
                '}';
    }
}

