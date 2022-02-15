package ots.test.core;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import ots.test.core.ConnectionManager;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prasun
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException,SQLException{
     Connection con= null;
     String q = "select * from users where userId=1";
     con = ConnectionManager.getConnection();
     Statement statemnt1 = con.createStatement();
     ResultSet rs =null;
     rs = statemnt1.executeQuery(q);
     display(rs);
    }
    public static void display(ResultSet rs) throws SQLException{

   while(rs.next())
   {
    int userId = rs.getInt("userId");
    String userFullName = rs.getString("userFullName");
    String email = rs.getString("email");
    String password = rs.getString("password");
    int userRoleId = rs.getInt("userRoleId");
    int userStatusId = rs.getInt("userStatusId");
    
    System.out.println("userId: "+userId+ "\n" +"userFullName: "+userFullName +"\n"+"email: "+email +"\n" +"password: "+password+"\n"+"userRoleId: "+userRoleId+"\n "+"userStatusId"+userStatusId);
   }
  
  }
}
