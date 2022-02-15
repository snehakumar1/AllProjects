/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlet;

import com.exavalu.pojos.Order;
import com.exavalu.pojos.Product;
import com.exavalu.pojos.User;
import com.exavalu.services.OrderService;
import com.exavalu.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class SaveProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String customer_name = request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        String productMake = request.getParameter("productMake");
        int Availability = Integer.parseInt(request.getParameter("Availability"));
        Product product = new Product();

        HttpSession session = request.getSession();
        User validUser = (User) session.getAttribute("validUser");
        if (validUser != null && validUser.isValidUser()) {
            product.setProductId(productId);
            product.setProductName(productMake);
            product.setProductPrice(productPrice);
            product.setProductMake(productMake);
            product.setAvaility(Availability);
            boolean success = ProductService.saveProduct(product);
            if (success) {
                System.out.println("Product updated");
                ArrayList<Product> products = ProductService.getAllProducts();
                request.setAttribute("Product", products);
                request.getRequestDispatcher("product.jsp").forward(request, response);

            } else {
                System.out.println("product not updated");
            }

        } else {
            String errorMsg = "You are not looged in..Please log in first";
            request.setAttribute("ErrorMsg", errorMsg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
