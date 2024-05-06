/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;
import entity.Category;
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
public class CategoryDAO implements Accessible<Category>{
    ServletContext sc ;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs; 

    public CategoryDAO(ServletContext sc, Connection conn, PreparedStatement ps, ResultSet rs) {
        this.sc = sc;
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }
    

    public CategoryDAO() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
        this.ps = ps;
        this.rs = rs;
    }
    
    @Override
    public boolean insertRec(Category obj) {
        try {
            ps = conn.prepareStatement("INSERT INTO categories ([categoryName],[memo])\n"
                    + "VALUES (?,?);");
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getMemo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateRec(String id, Category obj) {
        try {
            ps = conn.prepareStatement("Update categories \n"+
                    "Set [categoryName] = ? , [memo] = ? "
                    + "Where [typeId] = ? ;");
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getMemo());
            ps.setString(3, id);
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
            ps = conn.prepareStatement("DELETE FROM categories WHERE [typeId] = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Category getObjectById(String type) {
       try {
            ps = conn.prepareStatement("select * from categories where typeId = ? ");
            ps.setString(1, type);
            rs = ps.executeQuery();
            while(rs.next()){
                Category c = new Category(rs.getInt(1), rs.getNString(2), rs.getNString(3));
                return c;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    
    }

    @Override
    public ArrayList<Category> listAll() {
        try {
            ps = conn.prepareStatement("select * from categories");
            rs = ps.executeQuery();
            ArrayList<Category> ds = new ArrayList<>();
            while(rs.next()){
                Category c = new Category(rs.getInt(1), rs.getNString(2), rs.getNString(3));
                ds.add(c);
            }
            return ds;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
