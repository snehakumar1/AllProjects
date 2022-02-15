/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.pojos;

import com.exavalu.core.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Customer {

    private int customer_id;
    private String customer_name;
    private String customer_address;

    /**
     * @return the customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * @param customer_name the customer_name to set
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /**
     * @return the customer_address
     */
    public String getCustomer_address() {
        return customer_address;
    }

    /**
     * @param customer_address the customer_address to set
     */
    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public static ArrayList getAllCustomer() {
        ArrayList list = new ArrayList();

        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM orderinventories.customers2";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt("customerId"));
                customer.setCustomer_name(rs.getString("customerName"));
                customer.setCustomer_address(rs.getString("customerAddress"));
                list.add(customer);
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Customer getCustomer(int customerId) {
        Customer customer = null;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT customers2.customerId,\n"
                    + "    customers2.customerName,\n"
                    + "    customers2.customerAddress\n"
                    + "FROM products.customers2 where customerId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setCustomer_id(rs.getInt("customerId"));
                customer.setCustomer_name(rs.getString("customerName"));
                customer.setCustomer_address(rs.getString("customerAddress"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public static boolean saveCustomer(Customer customer) {
        boolean success = false;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "UPDATE products.customers2\n"
                    + "SET\n"
                    + "customerName = ?,\n"
                    + "customerAddress = ?\n"
                    + "WHERE customerId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getCustomer_address());
            ps.setInt(3, customer.getCustomer_id());
            int row=ps.executeUpdate();
            if(row>0){
                success=true;
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

}
