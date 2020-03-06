package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Employees implements Parcelable , Serializable {

    private int idEmployees;
    private String employeesUserName;
    private String employeesKey;
    private boolean employeesStatus;
    private int idUsers;
    private int idUsersRoles;
    private UsersRoles usersRoles;

    public Employees() {
    }

    public Employees(int idEmployees, String employeesUserName, String employeesKey, boolean employeesStatus, int idUsers, int idUsersRoles, UsersRoles usersRoles) {
        this.idEmployees = idEmployees;
        this.employeesUserName = employeesUserName;
        this.employeesKey = employeesKey;
        this.employeesStatus = employeesStatus;
        this.idUsers = idUsers;
        this.idUsersRoles = idUsersRoles;
        this.usersRoles = usersRoles;
    }

    protected Employees(Parcel in) {
        idEmployees = in.readInt();
        employeesUserName = in.readString();
        employeesKey = in.readString();
        employeesStatus = in.readByte() != 0;
        idUsers = in.readInt();
        idUsersRoles = in.readInt();
        usersRoles = in.readParcelable(UsersRoles.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idEmployees);
        dest.writeString(employeesUserName);
        dest.writeString(employeesKey);
        dest.writeByte((byte) (employeesStatus ? 1 : 0));
        dest.writeInt(idUsers);
        dest.writeInt(idUsersRoles);
        dest.writeParcelable(usersRoles, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employees> CREATOR = new Creator<Employees>() {
        @Override
        public Employees createFromParcel(Parcel in) {
            return new Employees(in);
        }

        @Override
        public Employees[] newArray(int size) {
            return new Employees[size];
        }
    };

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getEmployeesUserName() {
        return employeesUserName;
    }

    public void setEmployeesUserName(String employeesUserName) {
        this.employeesUserName = employeesUserName;
    }

    public String getEmployeesKey() {
        return employeesKey;
    }

    public void setEmployeesKey(String employeesKey) {
        this.employeesKey = employeesKey;
    }

    public boolean isEmployeesStatus() {
        return employeesStatus;
    }

    public void setEmployeesStatus(boolean employeesStatus) {
        this.employeesStatus = employeesStatus;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdUsersRoles() {
        return idUsersRoles;
    }

    public void setIdUsersRoles(int idUsersRoles) {
        this.idUsersRoles = idUsersRoles;
    }

    @Nullable
    public UsersRoles getUsersRoles() {
        return usersRoles;
    }

    public void setUsersRoles(@Nullable UsersRoles usersRoles) {
        this.usersRoles = usersRoles;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "idEmployees=" + idEmployees +
                ", employeesUserName='" + employeesUserName + '\'' +
                ", employeesKey='" + employeesKey + '\'' +
                ", employeesStatus=" + employeesStatus +
                ", idUsers=" + idUsers +
                ", idUsersRoles=" + idUsersRoles +
                ", usersRoles=" + usersRoles +
                '}';
    }
}
