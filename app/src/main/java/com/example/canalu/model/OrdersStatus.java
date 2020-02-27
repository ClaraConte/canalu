package com.example.canalu.model;

public class OrdersStatus {
    private int idOrdersStatus;
    private String ordersStatusName;

    public OrdersStatus() {
    }

    public OrdersStatus(int idOrdersStatus, String ordersStatusName) {
        this.idOrdersStatus = idOrdersStatus;
        this.ordersStatusName = ordersStatusName;
    }

    public int getIdOrdersStatus() {
        return idOrdersStatus;
    }

    public void setIdOrdersStatus(int idOrdersStatus) {
        this.idOrdersStatus = idOrdersStatus;
    }

    public String getOrdersStatusName() {
        return ordersStatusName;
    }

    public void setOrdersStatusName(String ordersStatusName) {
        this.ordersStatusName = ordersStatusName;
    }

    @Override
    public String toString() {
        return "OrdersStatus{" +
                "idOrdersStatus=" + idOrdersStatus +
                ", ordersStatusName='" + ordersStatusName + '\'' +
                '}';
    }
}
