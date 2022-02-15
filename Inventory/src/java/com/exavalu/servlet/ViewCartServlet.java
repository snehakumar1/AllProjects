/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlet;

import com.exavalu.pojos.Product;
import com.exavalu.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ViewCartServlet extends HttpServlet {

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
        ArrayList products = (ArrayList) request.getSession().getAttribute("cart");
        int i = 0;
        Product product = null;
        ArrayList cartProduct = new ArrayList();
        double price = 0;
        double subtotal =0;
        double tax = 0;
        while (i < products.size()) {
            product = (Product) products.get(i);
            int product_id = product.getProductId();
            int qty = product.getQuantity();
            Product orderProduct = new Product();
            orderProduct = ProductService.getProduct(product_id);
            
            
            subtotal = orderProduct.getProductPrice()*qty;
            orderProduct.setSubtotal(subtotal);
price = price + subtotal;
            orderProduct.setQuantity(qty);
            cartProduct.add(orderProduct);
            i++;
        }
 tax = price *0.4;
// i=0;
// Product cart=null;
// while(i<cartProduct.size()){
// cart=(Product)cartProduct.get(i);
// System.out.println("In Cart: "+cart.getProductName()+" "+cart.getQuantity()+ " "+cart.getProductMake());
// i++;
// }
        request.setAttribute("cartProduct", cartProduct);
        request.setAttribute("price", price);
        request.setAttribute("tax", tax);
        request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
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
