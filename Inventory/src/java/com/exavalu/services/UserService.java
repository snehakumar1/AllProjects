/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.core.ConnectionManager;
import com.exavalu.pojos.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UserService {
    public static User validateLoginCredential(User user){
        boolean valid=true;
        String username=user.getUsername();
        String password=user.getPassword();
        try {
            // we need to connect to Db or other system and validate user with username and password
            Connection con=ConnectionManager.getConnection();
            String sql="SELECT users.username,\n" +
"    users.password,\n" +
"    users.firstNmae,\n" +
"    users.lastName,\n" +
"    users.email,\n" +
"    users.phoneNumber\n" +
"FROM users where username =? and password = ?";
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1, username);
         ps.setString(2, password);
         
         ResultSet rs=ps.executeQuery();
         //rs.next();
            //System.out.println("rs.next: "+rs.next());
         if(rs.next()){
             //System.out.println("user service if condition");
             user.setUsername(rs.getString("username"));
             user.setPassword(rs.getString("password"));
             user.setFirstNmae(rs.getString("firstNmae"));
             user.setLastName(rs.getString("lastName"));
             user.setEmail(rs.getString("email"));
             user.setPhoneNumber(rs.getString("phoneNumber"));
             user.setValidUser(valid);
         }
         else{
             valid=false;
             user.setValidUser(valid);
         }
        } catch (IOException ex) {
            //Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            //Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public static boolean saveUser(User user){
        boolean success=false;
        try {
            Connection con=ConnectionManager.getConnection();
            String sql="INSERT INTO orderinventories.users\n" +
                        "(username,\n" +
                        "password,\n"
                    + "firstNmae,\n"
                    + "lastName,\n"
                    + "email,\n"
                    + "phoneNumber)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?);";
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstNmae());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhoneNumber());
            int row=ps.executeUpdate();
            if(row>0){
                success=true;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
