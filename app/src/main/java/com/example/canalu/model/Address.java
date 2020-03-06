package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Address implements Parcelable, Serializable {

        private int idAddress;
        private String addressStreet;
        private String addressNumber;
        private String addressDptoFloor;
        private String addressDptoNumber;
        private Double addressLatitude;
        private Double addressLongitude;
        private int idUsers;
        private int idAddressType;
        private String addressObservations;
        private int idLocations;
        private Locations locations;
        private int idCommerces;
        private Commerces commerces;

        public Address() {
        }

        public Address(int idAddress, String addressStreet, String addressNumber, String addressDptoFloor, String addressDptoNumber, Double addressLatitude, Double addressLongitude, int idUsers, int idAddressType, String addressObservations, int idLocations, Locations locations, int idCommerces, Commerces commerces) {
                this.idAddress = idAddress;
                this.addressStreet = addressStreet;
                this.addressNumber = addressNumber;
                this.addressDptoFloor = addressDptoFloor;
                this.addressDptoNumber = addressDptoNumber;
                this.addressLatitude = addressLatitude;
                this.addressLongitude = addressLongitude;
                this.idUsers = idUsers;
                this.idAddressType = idAddressType;
                this.addressObservations = addressObservations;
                this.idLocations = idLocations;
                this.locations = locations;
                this.idCommerces = idCommerces;
                this.commerces = commerces;
        }

        protected Address(Parcel in) {
                idAddress = in.readInt();
                addressStreet = in.readString();
                addressNumber = in.readString();
                addressDptoFloor = in.readString();
                addressDptoNumber = in.readString();
                if (in.readByte() == 0) {
                        addressLatitude = null;
                } else {
                        addressLatitude = in.readDouble();
                }
                if (in.readByte() == 0) {
                        addressLongitude = null;
                } else {
                        addressLongitude = in.readDouble();
                }
                idUsers = in.readInt();
                idAddressType = in.readInt();
                addressObservations = in.readString();
                idLocations = in.readInt();
                locations = in.readParcelable(Locations.class.getClassLoader());
                idCommerces = in.readInt();
                commerces = in.readParcelable(Commerces.class.getClassLoader());
        }

        public static final Creator<Address> CREATOR = new Creator<Address>() {
                @Override
                public Address createFromParcel(Parcel in) {
                        return new Address(in);
                }

                @Override
                public Address[] newArray(int size) {
                        return new Address[size];
                }
        };

        public int getIdAddress() {
                return idAddress;
        }

        public void setIdAddress(int idAddress) {
                this.idAddress = idAddress;
        }

        public String getAddressStreet() {
                return addressStreet;
        }

        public void setAddressStreet(String addressStreet) {
                this.addressStreet = addressStreet;
        }

        public String getAddressNumber() {
                return addressNumber;
        }

        public void setAddressNumber(String addressNumber) {
                this.addressNumber = addressNumber;
        }

        public String getAddressDptoFloor() {
                return addressDptoFloor;
        }

        public void setAddressDptoFloor(String addressDptoFloor) {
                this.addressDptoFloor = addressDptoFloor;
        }

        public String getAddressDptoNumber() {
                return addressDptoNumber;
        }

        public void setAddressDptoNumber(String addressDptoNumber) {
                this.addressDptoNumber = addressDptoNumber;
        }

        public Double getAddressLatitude() {
                return addressLatitude;
        }

        public void setAddressLatitude(Double addressLatitude) {
                this.addressLatitude = addressLatitude;
        }

        public Double getAddressLongitude() {
                return addressLongitude;
        }

        public void setAddressLongitude(Double addressLongitude) {
                this.addressLongitude = addressLongitude;
        }

        public int getIdUsers() {
                return idUsers;
        }

        public void setIdUsers(int idUsers) {
                this.idUsers = idUsers;
        }

        public int getIdAddressType() {
                return idAddressType;
        }

        public void setIdAddressType(int idAddressType) {
                this.idAddressType = idAddressType;
        }

        public String getAddressObservations() {
                return addressObservations;
        }

        public void setAddressObservations(String addressObservations) {
                this.addressObservations = addressObservations;
        }

        public int getIdLocations() {
                return idLocations;
        }

        public void setIdLocations(int idLocations) {
                this.idLocations = idLocations;
        }

        public Locations getLocations() {
                return locations;
        }

        public void setLocations(Locations locations) {
                this.locations = locations;
        }

        public int getIdCommerces() {
                return idCommerces;
        }

        public void setIdCommerces(int idCommerces) {
                this.idCommerces = idCommerces;
        }

        public Commerces getCommerces() {
                return commerces;
        }

        public void setCommerces(Commerces commerces) {
                this.commerces = commerces;
        }

        @Override
        public String toString() {
                return "Address{" +
                        "idAddress=" + idAddress +
                        ", addressStreet='" + addressStreet + '\'' +
                        ", addressNumber='" + addressNumber + '\'' +
                        ", addressDptoFloor='" + addressDptoFloor + '\'' +
                        ", addressDptoNumber='" + addressDptoNumber + '\'' +
                        ", addressLatitude=" + addressLatitude +
                        ", addressLongitude=" + addressLongitude +
                        ", idUsers=" + idUsers +
                        ", idAddressType=" + idAddressType +
                        ", addressObservations='" + addressObservations + '\'' +
                        ", idLocations=" + idLocations +
                        ", locations=" + locations +
                        ", idCommerces=" + idCommerces +
                        ", commerces=" + commerces +
                        '}';
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(idAddress);
                dest.writeString(addressStreet);
                dest.writeString(addressNumber);
                dest.writeString(addressDptoFloor);
                dest.writeString(addressDptoNumber);
                if (addressLatitude == null) {
                        dest.writeByte((byte) 0);
                } else {
                        dest.writeByte((byte) 1);
                        dest.writeDouble(addressLatitude);
                }
                if (addressLongitude == null) {
                        dest.writeByte((byte) 0);
                } else {
                        dest.writeByte((byte) 1);
                        dest.writeDouble(addressLongitude);
                }
                dest.writeInt(idUsers);
                dest.writeInt(idAddressType);
                dest.writeString(addressObservations);
                dest.writeInt(idLocations);
                dest.writeParcelable(locations, flags);
                dest.writeInt(idCommerces);
                dest.writeParcelable(commerces, flags);
        }
}
