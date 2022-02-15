/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlet;

import com.exavalu.pojos.Customer;
import com.exavalu.pojos.Order;
import com.exavalu.pojos.User;
import com.exavalu.services.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class PlaceNewOrderServlet extends HttpServlet {

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
        int orderId=Integer.parseInt(request.getParameter("orderId"));
        String customer_name=request.getParameter("customerName");
        String orderDate=request.getParameter("orderDate");
        double orderValue=Double.parseDouble(request.getParameter("orderValue"));
        double taxAmount=Double.parseDouble(request.getParameter("taxAmount"));
        String destinationCity=request.getParameter("destinationCity");
        String destinationCountry=request.getParameter("destinationCountry");
        Order order=new Order();
        
           HttpSession session = request.getSession();
        User  validUser = (User)session.getAttribute("validUser");
        if(validUser != null && validUser.isValidUser()){
            order.setOrder_id(orderId);
            order.setCustomaer_name(customer_name);
            order.setOrder_date(orderDate);
            order.setOrder_value(orderValue);
            order.setTax_amount(taxAmount);
            order.setDestination_city(destinationCity);
            order.setDestination_country(destinationCountry);
            boolean success=OrderService.placeNewOrder(order);
            if(success){
             ArrayList list=Customer.getAllCustomer();
            request.setAttribute("customer", list);
            request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
             
            }
            
        }else{
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
