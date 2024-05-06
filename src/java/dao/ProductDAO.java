    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;
import entity.Account;
import entity.Category;
import entity.Products;
import interfaces.Accessible;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Michael Dang
 */
public class ProductDAO implements Accessible<Products> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductDAO(ServletContext sc) {
        this.sc = sc;
    }

    public ProductDAO() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public boolean insertRec(Products obj) {
        try {
            
            ps = conn.prepareStatement("INSERT INTO products ([productId], [productName], [productImage], [brief],[postedDate],[typeId],"
                    + "[account],[unit] ,[price],[discount] )\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, obj.getProductID());
            ps.setString(2, obj.getProductName());
            ps.setString(3, obj.getProductImage());
            ps.setString(4, obj.getBrief());
            ps.setDate(5, obj.getPostedDate());
            ps.setInt(6,obj.getTypeID().getTypeID());
            ps.setString(7,obj.getAccount().getAccount());
            ps.setString(8, obj.getUnit());
            ps.setInt(9, obj.getPrice());
            ps.setInt(10, obj.getDiscount());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateRec(String id, Products obj) {
        try {
            ps = conn.prepareStatement("Update products "
                    + "Set [productName] = ?, [productImage] = ?, [brief] = ?,[postedDate] = ?,[typeId] = ?,"
                    + "[account] = ?,[unit] = ? ,[price] = ?,[discount]  = ? \n"
                    + "Where [productId] = ?;");
            ps.setString(1, obj.getProductName());
            ps.setString(2, obj.getProductImage());
            ps.setString(3, obj.getBrief());
            ps.setDate(4, obj.getPostedDate());
            ps.setString(5,String.valueOf(obj.getTypeID().getTypeID()));
            ps.setString(6,String.valueOf(obj.getAccount().getAccount()));
            ps.setString(7, obj.getUnit());
            ps.setInt(8, obj.getPrice());
            ps.setInt(9, obj.getDiscount());
            ps.setString(10,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteRec(String id) {
        try {
            ps = conn.prepareStatement("DELETE FROM products WHERE [productId] = ? ");
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public Products getObjectById(String id) {
        try {
            ps = conn.prepareStatement("Select * from products where [productId] = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = null;
                Category c = null;
                int typeId = rs.getInt(6);
                String typeIdstring = String.valueOf(typeId);
                try {
                    c = new CategoryDAO().getObjectById(typeIdstring);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                }
                String account = rs.getString(7);
                try {
                    acc = new AccountDAO().getObjectById(account);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                Products p = new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), c, acc, rs.getString(8), rs.getInt(9), rs.getInt(10));
                return p;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Products> getByTypeID(String type){
        try {
            ps = conn.prepareStatement("select * from products where typeId = ?");
            ps.setString(1,type);
            rs = ps.executeQuery();
            ArrayList<Products> ds = new ArrayList<>();
            while (rs.next()) {
                Account acc = null;
                Category c = null;
                int typeId = rs.getInt(6);
                String typeIdstring = String.valueOf(typeId);
                try {
                    c = new CategoryDAO().getObjectById(typeIdstring);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                }
                String account = rs.getString(7);
                try {
                    acc = new AccountDAO().getObjectById(account);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                Products p = new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), c, acc, rs.getString(8), rs.getInt(9), rs.getInt(10));
                ds.add(p);
            }
            return ds;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Products> getByName(String name){
        try {
            ps = conn.prepareStatement("Select * from products where productName like ?");
            ps.setString(1, "%"+name+"%");
            rs = ps.executeQuery();
            ArrayList<Products> ds = new ArrayList<>();
            while (rs.next()) {
                Account acc = null;
                Category c = null;
                int typeId = rs.getInt(6);
                String typeIdstring = String.valueOf(typeId);
                try {
                    c = new CategoryDAO().getObjectById(typeIdstring);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                }
                String account = rs.getString(7);
                try {
                    acc = new AccountDAO().getObjectById(account);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                Products p = new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), c, acc, rs.getString(8), rs.getInt(9), rs.getInt(10));
                ds.add(p);
            }
            return ds;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Products> listAll() {
        try {
            ps = conn.prepareStatement("Select * from products");
            rs = ps.executeQuery();
            ArrayList<Products> ds = new ArrayList<>();
            while (rs.next()) {
                Account acc = null;
                Category c = null;
                int typeId = rs.getInt(6);
                String typeIdstring = String.valueOf(typeId);
                try {
                    c = new CategoryDAO().getObjectById(typeIdstring);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                }
                String account = rs.getString(7);
                try {
                    acc = new AccountDAO().getObjectById(account);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                Products p = new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), c, acc, rs.getString(8), rs.getInt(9), rs.getInt(10));
                ds.add(p);
            }
            return ds;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
