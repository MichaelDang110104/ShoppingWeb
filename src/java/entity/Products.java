/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Michael Dang
 */
public class Products {
    private String productID;
    private String productName;
    private String productImage;
    private String brief;
    private Date postedDate;
    private Category typeID;
    private Account account;
    private String unit;
    private int price;
    private int discount;

    public Products() {
    }

    public Products(String productID, String productName, String productImage, String brief, Date postedDate, Category typeID, Account account, String unit, int price, int discount) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.brief = brief;
        this.postedDate = postedDate;
        this.typeID = typeID;
        this.account = account;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Category getTypeID() {
        return typeID;
    }

    public void setTypeID(Category typeID) {
        this.typeID = typeID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Products{" + "productID=" + productID + ", productName=" + productName + ", productImage=" + productImage + ", brief=" + brief + ", postedDate=" + postedDate + ", typeID=" + typeID + ", account=" + account + ", unit=" + unit + ", price=" + price + ", discount=" + discount + '}';
    }
    
}
