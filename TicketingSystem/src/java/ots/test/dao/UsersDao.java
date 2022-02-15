/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ots.test.beans.Users;
import ots.test.core.ConnectionManager;

/**
 *
 * @author prasun
 */
public class UsersDao {

    public Users validateLoginCredentials(String email, String password) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        Users users=null;
         try {
        con = ConnectionManager.getConnection();
        String sql = "SELECT * FROM ticketsystem.users where email=? and password=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        System.out.println("Got the connection.........................." + con);
        System.out.println("Select SQL = " + ps);
         rs = ps.executeQuery();
        if (rs.next()) {
            users=new Users();
            users.setUserId(rs.getInt("userId"));
            users.setUserFullName(rs.getString("userFullName"));
            users.setEmail(rs.getString("email"));
            users.setPassword(rs.getString("password"));
            users.setRoleId(rs.getInt("roleId"));
            users.setStatusId(rs.getInt("statusId"));
            users.setValidUser(true);
            
    }
        return users;
    }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (con != null) {
                con.close();
            }
         }
    }
    

}
