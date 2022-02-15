/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.core.ConnectionManager;
import com.exavalu.pojos.Order;
import com.exavalu.pojos.Product;
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
public class ProductService {

    public static ArrayList getAllProducts() {
        ArrayList list = new ArrayList();

        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM products ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Product Id: " + rs.getInt("productId"));
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getFloat("price"));
                product.setProductMake(rs.getString("productMake"));
                product.setAvaility(rs.getInt("availability"));

                list.add(product);
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

    public static Product getProduct(int productId) {
        Product product = null;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "SELECT products.productId,\n"
                    + "    products.productName,\n"
                    + "    products.productMake,\n"
                    + "    products.price,\n"
                    + "    products.availability\n"
                    + "FROM orderinventories.products where productId=?;";
//String sql = "SELECT * FROM products where productId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getFloat("price"));
                product.setProductMake(rs.getString("productMake"));
                product.setAvaility(rs.getInt("availability"));

            }
        } catch (IOException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public static boolean saveProduct(Product product) {
        boolean success = false;
        try {
            Connection con = ConnectionManager.getConnection();
            String sql = "UPDATE products.product\n"
                    + "SET\n"
                    + "product_name = ?,\n"
                    + "product_price = ?,\n"
                    + "product_make = ?,\n"
                    + "product_availability =  ?\n"
                    + "WHERE product_id =  ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setFloat(2, product.getProductPrice());
            ps.setString(3, product.getProductMake());
            ps.setInt(4, product.getAvaility());
            ps.setInt(5, product.getProductId());

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
