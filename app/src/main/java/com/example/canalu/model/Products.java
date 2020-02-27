package com.example.canalu.model;

import java.io.Serializable;

public class Products implements Serializable {

    private int idProducts;
    private String productsName;
    private int idCategories;
    private String productsDescriptions;
    private Double productsUnitPrice;
    private String productsBarCode;
    private String productsExpirationsDate;
    private String productsImage;
    private boolean productsStatus;
    private int productsMinStock;
    private int idBrands;
    private String productsDimensions;
    private Double productsWeight;
    private int idProductsMeasures;
    private int idProductsPricesType;

    public Products() {
    }

    public Products(int idProducts, String productsName, int idCategories, String productsDescriptions, Double productsUnitPrice, String productsBarCode, String productsExpirationsDate, String productsImage, boolean productsStatus, int productsMinStock, int idBrands, String productsDimensions, Double productsWeight, int idProductsMeasures, int idProductsPricesType) {
        this.idProducts = idProducts;
        this.productsName = productsName;
        this.idCategories = idCategories;
        this.productsDescriptions = productsDescriptions;
        this.productsUnitPrice = productsUnitPrice;
        this.productsBarCode = productsBarCode;
        this.productsExpirationsDate = productsExpirationsDate;
        this.productsImage = productsImage;
        this.productsStatus = productsStatus;
        this.productsMinStock = productsMinStock;
        this.idBrands = idBrands;
        this.productsDimensions = productsDimensions;
        this.productsWeight = productsWeight;
        this.idProductsMeasures = idProductsMeasures;
        this.idProductsPricesType = idProductsPricesType;
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getProductsDescriptions() {
        return productsDescriptions;
    }

    public void setProductsDescriptions(String productsDescriptions) {
        this.productsDescriptions = productsDescriptions;
    }

    public Double getProductsUnitPrice() {
        return productsUnitPrice;
    }

    public void setProductsUnitPrice(Double productsUnitPrice) {
        this.productsUnitPrice = productsUnitPrice;
    }

    public String getProductsBarCode() {
        return productsBarCode;
    }

    public void setProductsBarCode(String productsBarCode) {
        this.productsBarCode = productsBarCode;
    }

    public String getProductsExpirationsDate() {
        return productsExpirationsDate;
    }

    public void setProductsExpirationsDate(String productsExpirationsDate) {
        this.productsExpirationsDate = productsExpirationsDate;
    }

    public String getProductsImage() {
        return productsImage;
    }

    public void setProductsImage(String productsImage) {
        this.productsImage = productsImage;
    }

    public boolean isProductsStatus() {
        return productsStatus;
    }

    public void setProductsStatus(boolean productsStatus) {
        this.productsStatus = productsStatus;
    }

    public int getProductsMinStock() {
        return productsMinStock;
    }

    public void setProductsMinStock(int productsMinStock) {
        this.productsMinStock = productsMinStock;
    }

    public int getIdBrands() {
        return idBrands;
    }

    public void setIdBrands(int idBrands) {
        this.idBrands = idBrands;
    }

    public String getProductsDimensions() {
        return productsDimensions;
    }

    public void setProductsDimensions(String productsDimensions) {
        this.productsDimensions = productsDimensions;
    }

    public Double getProductsWeight() {
        return productsWeight;
    }

    public void setProductsWeight(Double productsWeight) {
        this.productsWeight = productsWeight;
    }

    public int getIdProductsMeasures() {
        return idProductsMeasures;
    }

    public void setIdProductsMeasures(int idProductsMeasures) {
        this.idProductsMeasures = idProductsMeasures;
    }

    public int getIdProductsPricesType() {
        return idProductsPricesType;
    }

    public void setIdProductsPricesType(int idProductsPricesType) {
        this.idProductsPricesType = idProductsPricesType;
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProducts=" + idProducts +
                ", productsName='" + productsName + '\'' +
                ", idCategories=" + idCategories +
                ", productsDescriptions='" + productsDescriptions + '\'' +
                ", productsUnitPrice=" + productsUnitPrice +
                ", productsBarCode='" + productsBarCode + '\'' +
                ", productsExpirationsDate='" + productsExpirationsDate + '\'' +
                ", productsImage='" + productsImage + '\'' +
                ", productsStatus=" + productsStatus +
                ", productsMinStock=" + productsMinStock +
                ", idBrands=" + idBrands +
                ", productsDimensions='" + productsDimensions + '\'' +
                ", productsWeight=" + productsWeight +
                ", idProductsMeasures=" + idProductsMeasures +
                ", idProductsPricesType=" + idProductsPricesType +
                '}';
    }
}
