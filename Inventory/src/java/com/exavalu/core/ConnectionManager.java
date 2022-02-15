/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.core;

//import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class ConnectionManager {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
        Connection con=null;
        //ConfigFileReader configFileReader=new ConfigFileReader();
        //ConfigParam configParam=configFileReader.getConfigParam();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/orderinventories";
        String user="root";
        String password="root"; 
         con=(Connection) DriverManager.getConnection(url, user, password);
         return con;
    }
}
