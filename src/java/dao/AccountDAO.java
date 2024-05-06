/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;
import entity.Account;
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
public class AccountDAO implements Accessible<Account> {

    private ServletContext sc;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public AccountDAO() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
        this.ps = ps;
        this.rs = rs;
    }

    public AccountDAO(ServletContext sc) {
        this.sc = sc;
    }
    
    public Account checkLogin(String name , String pass){
        try {
            ps = conn.prepareStatement("Select * from accounts where account = ? and pass = ?");
            ps.setString(1, name);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), rs.getInt(9));
                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public boolean changeCondition(String id, boolean condition){
        try {
            ps = conn.prepareStatement("UPDATE accounts \n"
                    + "SET isUse = ? \n"
                    + "WHERE account = ? ");
            ps.setBoolean(1, condition);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean insertRec(Account obj) {
        try {
            ps = conn.prepareStatement("INSERT INTO accounts (account, pass, lastName, firstName,birthday,gender,phone,isUse ,roleInSystem)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?);");
            ps.setString(1, obj.getAccount());
            ps.setString(2, obj.getPassword());
            ps.setNString(3, obj.getLastName());
            ps.setNString(4, obj.getFirstName());
            ps.setDate(5, obj.getBirthday());
            ps.setBoolean(6, obj.isGender());
            ps.setString(7, obj.getPhone());
            ps.setBoolean(8, obj.isIsUse());
            ps.setInt(9, obj.getRoleInSystem());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

        public  boolean updateCondition(String id,boolean condition){
            try {
            ps = conn.prepareStatement("UPDATE accounts \n"
                    + "SET isUse = ? "
                    + "WHERE account = ? ");
            ps.setBoolean(1, condition);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
        }
    @Override
    public boolean updateRec(String id, Account obj) {
        try {
            ps = conn.prepareStatement("UPDATE accounts \n"
                    + "SET pass = ? , lastName = ? ,firstName = ? , birthday = ? ,gender = ? ,phone = ? ,isUse = ? ,roleInSystem = ? \n"
                    + "WHERE account = ? ");
            ps.setString(1, obj.getPassword());
            ps.setNString(2, obj.getLastName());
            ps.setNString(3, obj.getFirstName());
            ps.setDate(4, obj.getBirthday());
            ps.setBoolean(5, obj.isGender());
            ps.setString(6, obj.getPhone());
            ps.setBoolean(7, obj.isIsUse());
            ps.setInt(8, obj.getRoleInSystem());
            ps.setString(9, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteRec(String account) {
        try {
            ps = conn.prepareStatement("DELETE FROM accounts WHERE account = ? ");
            ps.setString(1, account);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Account getObjectById(String id) {
        try {
            ps = conn.prepareStatement("Select * from accounts where account = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            ArrayList<Account> ds = new ArrayList<>();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), rs.getInt(9));
                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Account> listAll() {
        try {
            ps = conn.prepareStatement("Select * from accounts");
            rs = ps.executeQuery();
            ArrayList<Account> ds = new ArrayList<>();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7), rs.getBoolean(8), rs.getInt(9));
                ds.add(a);
            }
            return ds;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
