/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.core.ConnectionManager;
import com.exavalu.pojos.Order;
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
public class OrderService {

    public static ArrayList getAllOrders() {
        ArrayList list = new ArrayList();

        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM orderinventories.order";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getInt("OrderId"));
                order.setCustomaer_name(rs.getString("CustomerName"));
                order.setOrder_date(rs.getString("OrderDate"));
                order.setOrder_value(rs.getDouble("OrderValue"));
                order.setTax_amount(rs.getDouble("TaxAmmount"));
                order.setDestination_city(rs.getString("DestinationCity"));
                order.setDestination_country(rs.getString("DestinationCountry"));

                list.add(order);
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Order getOrder(int orderId) {
        Order order = null;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT order.OrderId,\n"
                    + "    order.CustomerName,\n"
                    + "    order.OrderDate,\n"
                    + "    order.OrderValue,\n"
                    + "    order.TaxAmmount,\n"
                    + "    order.DestinationCity,\n"
                    + "    order.DestinationCountry\n"
                    + "FROM orderinventories.order where OrderId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order();
                order.setOrder_id(rs.getInt("OrderId"));
                order.setCustomaer_name(rs.getString("CustomerName"));
                order.setOrder_date(rs.getString("OrderDate"));
                order.setOrder_value(rs.getDouble("OrderValue"));
                order.setTax_amount(rs.getDouble("TaxAmmount"));
                order.setDestination_city(rs.getString("DestinationCity"));
                order.setDestination_country(rs.getString("DestinationCountry"));

            }
        } catch (IOException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    public static boolean saveOrder(Order order) {
        boolean success = false;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "UPDATE orderinventories.order\n"
                    + "SET\n"
                    + "CustomerName = ?,\n"
                    + "OrderDate = ?,\n"
                    + "OrderValue = ?,\n"
                    + "TaxAmmount = ?,\n"
                    + "DestinationCity = ?,\n"
                    + "DestinationCountry = ?\n"
                    + "WHERE OrderId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, order.getCustomaer_name());
            ps.setString(2, order.getOrder_date());
            ps.setDouble(3, order.getOrder_value());
            ps.setDouble(4, order.getTax_amount());
            ps.setString(5, order.getDestination_city());
            ps.setString(6, order.getDestination_country());
            ps.setInt(7, order.getOrder_id());

            int row = ps.executeUpdate();
            if (row > 0) {
                success = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public static boolean placeNewOrder(Order order) {
        boolean success = false;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "INSERT INTO products.order1\n"
                    + "(order_id,\n"
                    + "customer_name,\n"
                    + "order_date,\n"
                    + "order_value,\n"
                    + "tax_amount,\n"
                    + "destination_city,\n"
                    + "destination_country)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getOrder_id());
            ps.setString(2, order.getCustomaer_name());
            ps.setString(3, order.getOrder_date());
            ps.setDouble(4, order.getOrder_value());
            ps.setDouble(5, order.getTax_amount());
            ps.setString(6, order.getDestination_city());
            ps.setString(7, order.getDestination_country());

            int row = ps.executeUpdate();
            if (row > 0) {
                success = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
