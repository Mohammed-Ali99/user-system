/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudoperationproject.controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class DBConnection {

    private static Connection con;
    Statement stat;
    
    private DBConnection() {
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cruddb", "root", "");

            } catch (ClassNotFoundException | SQLException ex) {
                ex.getMessage();
            }

        }
        return con;
    }
    
    public static void disconnect() {
        if(con != null) {
            con = null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(DBConnection.getConnection());
    }
    
    
}
