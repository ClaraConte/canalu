package com.example.canalu.model;

public class OrdersDetails {

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
}
