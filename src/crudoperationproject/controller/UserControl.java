/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudoperationproject.controller;

import crudoperationproject.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

/**
 *
 * @author Mohamed
 */
public class UserControl {
 
    Statement st; 
    
    public void insert(User user) {
        try {
            st = DBConnection.getConnection().createStatement();
            st.executeUpdate("insert into users(name , age , year) values (' " + user.getName() + "' , " + user.getAge() + " , " + user.getYear() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(User user) {
        try {
            st = DBConnection.getConnection().createStatement();
            st.executeUpdate("update users set name = ' " + user.getName() + " ' , age = " + user.getAge() + " , year = " + user.getYear() + " where id = " + user.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Delete(int id) {
        
        try {
            st = DBConnection.getConnection().createStatement();
            st.executeUpdate("delete from users where id = " + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    public ObservableList<User> getAllUsers() {
        
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        
        try {
            st = DBConnection.getConnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from users");
            resultSet.beforeFirst();
            
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setYear(resultSet.getInt(4));
                
                allUsers.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allUsers;
    }
    
    
    public ObservableList<User> search(String name) {
        
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        
        try {
            st = DBConnection.getConnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from users where name like '%" + name + "%' ");
            resultSet.beforeFirst();
            
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setYear(resultSet.getInt(4));
                
                allUsers.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allUsers;
    }
    

    
}
