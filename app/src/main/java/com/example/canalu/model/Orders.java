package com.example.canalu.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Orders implements Serializable {

    private int idOrders;
    private int idEmployees;
    private int idUsers;
    private Users users;
    private ArrayList<OrdersDetails> ordersDetails;
    private OrdersStatus ordersStatus;
    private int idOrderStatus;
    private String  ordersDate;
    private String ordersDispatchDate;

    public Orders() {
    }

    public Orders(int idOrders, int idEmployees, int idUsers, Users users, ArrayList<OrdersDetails> ordersDetails, OrdersStatus ordersStatus, int idOrderStatus, String ordersDate, String ordersDispatchDate) {
        this.idOrders = idOrders;
        this.idEmployees = idEmployees;
        this.idUsers = idUsers;
        this.users = users;
        this.ordersDetails = ordersDetails;
        this.ordersStatus = ordersStatus;
        this.idOrderStatus = idOrderStatus;
        this.ordersDate = ordersDate;
        this.ordersDispatchDate = ordersDispatchDate;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
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

    public ArrayList<OrdersDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(ArrayList<OrdersDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public OrdersStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public String getOrdersDispatchDate() {
        return ordersDispatchDate;
    }

    public void setOrdersDispatchDate(String ordersDispatchDate) {
        this.ordersDispatchDate = ordersDispatchDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrders=" + idOrders +
                ", idEmployees=" + idEmployees +
                ", idUsers=" + idUsers +
                ", users=" + users +
                ", ordersDetails=" + ordersDetails +
                ", ordersStatus=" + ordersStatus +
                ", idOrderStatus=" + idOrderStatus +
                ", ordersDate='" + ordersDate + '\'' +
                ", ordersDispatchDate='" + ordersDispatchDate + '\'' +
                '}';
    }
}
