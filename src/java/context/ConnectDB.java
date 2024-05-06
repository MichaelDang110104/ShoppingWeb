/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 *
 * @author Michael Dang
 */
public class ConnectDB {
    private String hostName;
    private String instance;
    private String port;
    private String dbName;
    private String userName;
    private String userPass;

    public ConnectDB() {
        this.hostName="127.0.0.1"; //localhost
        this.port="1433";
        this.dbName="ProductIntro";
        this.userName="sa";
        this.userPass="12345";
    }

    
    public ConnectDB(String hostName, String port, String dbName, String userName, String userPass) {
        this.hostName = hostName;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.userPass = userPass;
    }
    
    public ConnectDB(ServletContext sc){
        this.hostName=sc.getInitParameter("hostAddress");
        this.instance = sc.getInitParameter("instance");
        this.dbName = sc.getInitParameter("dbName");
        this.port = sc.getInitParameter("dbPort");
        this.userName = sc.getInitParameter("userName");
        this.userPass = sc.getInitParameter("userPass");
    }
    
    public String getConnectURL(){
        return "jdbc:sqlserver://"+this.hostName+
               ":"+this.port+";"+"databaseName="+this.dbName+";"+
                "user="+this.userName+";"+"password="+this.userPass+";";
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(this.getConnectURL());
    }
}
