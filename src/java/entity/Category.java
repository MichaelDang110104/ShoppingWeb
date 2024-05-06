/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Michael Dang
 */
public class Category {
    private int typeID;
    private String categoryName;
    private String memo;

    public Category() {
    }
    
    public Category(String categoryName, String memo) {
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public Category(int typeID, String categoryName, String memo) {
        this.typeID = typeID;
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Categories{" + "typeID=" + typeID + ", categoryName=" + categoryName + ", memo=" + memo + '}';
    }
    
}
