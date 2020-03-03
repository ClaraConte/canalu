package com.example.canalu.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class OrdersDetails  implements  Serializable, Parcelable {

    private int idOrdersDetails;
    private int idOrders;
    private Products products;
    private int idProducts;
    private int ordersDetailsTotalProducts;

    public OrdersDetails() {
    }

    public OrdersDetails(int idOrdersDetails, int idOrders, Products products, int idProducts, int ordersDetailsTotalProducts) {
        this.idOrdersDetails = idOrdersDetails;
        this.idOrders = idOrders;
        this.products = products;
        this.idProducts = idProducts;
        this.ordersDetailsTotalProducts = ordersDetailsTotalProducts;
    }

    protected OrdersDetails(Parcel in) {
        idOrdersDetails = in.readInt();
        idOrders = in.readInt();
        products = in.readParcelable(Products.class.getClassLoader());
        idProducts = in.readInt();
        ordersDetailsTotalProducts = in.readInt();
    }

    public static final Creator<OrdersDetails> CREATOR = new Creator<OrdersDetails>() {
        @Override
        public OrdersDetails createFromParcel(Parcel in) {
            return new OrdersDetails(in);
        }

        @Override
        public OrdersDetails[] newArray(int size) {
            return new OrdersDetails[size];
        }
    };

    public int getIdOrdersDetails() {
        return idOrdersDetails;
    }

    public void setIdOrdersDetails(int idOrdersDetails) {
        this.idOrdersDetails = idOrdersDetails;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public int getOrdersDetailsTotalProducts() {
        return ordersDetailsTotalProducts;
    }

    public void setOrdersDetailsTotalProducts(int ordersDetailsTotalProducts) {
        this.ordersDetailsTotalProducts = ordersDetailsTotalProducts;
    }

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "idOrdersDetails=" + idOrdersDetails +
                ", idOrders=" + idOrders +
                ", products=" + products +
                ", idProducts=" + idProducts +
                ", ordersDetailsTotalProducts=" + ordersDetailsTotalProducts +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idOrdersDetails);
        dest.writeInt(idOrders);
        dest.writeParcelable(products, flags);
        dest.writeInt(idProducts);
        dest.writeInt(ordersDetailsTotalProducts);
    }
}
