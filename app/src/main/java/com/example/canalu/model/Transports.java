package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Transports implements Parcelable, Serializable {
    private int IdTransports;
    private String TransportsDomains;
    private String TransportsFuelsTypes;
    private Double TransportsKms;
    private String TransportsBrands;

    public Transports() {
    }

    public Transports(int idTransports, String transportsDomains, String transportsFuelsTypes, Double transportsKms, String transportsBrands) {
        IdTransports = idTransports;
        TransportsDomains = transportsDomains;
        TransportsFuelsTypes = transportsFuelsTypes;
        TransportsKms = transportsKms;
        TransportsBrands = transportsBrands;
    }

    protected Transports(Parcel in) {
        IdTransports = in.readInt();
        TransportsDomains = in.readString();
        TransportsFuelsTypes = in.readString();
        if (in.readByte() == 0) {
            TransportsKms = null;
        } else {
            TransportsKms = in.readDouble();
        }
        TransportsBrands = in.readString();
    }

    public static final Creator<Transports> CREATOR = new Creator<Transports>() {
        @Override
        public Transports createFromParcel(Parcel in) {
            return new Transports(in);
        }

        @Override
        public Transports[] newArray(int size) {
            return new Transports[size];
        }
    };

    public int getIdTransports() {
        return IdTransports;
    }

    public void setIdTransports(int idTransports) {
        IdTransports = idTransports;
    }

    public String getTransportsDomains() {
        return TransportsDomains;
    }

    public void setTransportsDomains(String transportsDomains) {
        TransportsDomains = transportsDomains;
    }

    public String getTransportsFuelsTypes() {
        return TransportsFuelsTypes;
    }

    public void setTransportsFuelsTypes(String transportsFuelsTypes) {
        TransportsFuelsTypes = transportsFuelsTypes;
    }

    public Double getTransportsKms() {
        return TransportsKms;
    }

    public void setTransportsKms(Double transportsKms) {
        TransportsKms = transportsKms;
    }

    public String getTransportsBrands() {
        return TransportsBrands;
    }

    public void setTransportsBrands(String transportsBrands) {
        TransportsBrands = transportsBrands;
    }

    @Override
    public String toString() {
        return "Transports{" +
                "IdTransports=" + IdTransports +
                ", TransportsDomains='" + TransportsDomains + '\'' +
                ", TransportsFuelsTypes='" + TransportsFuelsTypes + '\'' +
                ", TransportsKms=" + TransportsKms +
                ", TransportsBrands='" + TransportsBrands + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(IdTransports);
        dest.writeString(TransportsDomains);
        dest.writeString(TransportsFuelsTypes);
        if (TransportsKms == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(TransportsKms);
        }
        dest.writeString(TransportsBrands);
    }
}
