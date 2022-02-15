/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlet;

import com.exavalu.pojos.User;
import com.exavalu.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Lenovo
 */
public class LoginServelet extends HttpServlet {
    // servlet is a special java class which understand http protocol
    //your servlet should always extend HttpServlet
    //What is HttpServlet?- this inherits some methods like
    // init,service,destroy-these methods are callsed servlet lifecycle methods.
    //can you figure out other classes which are smilar to genericServlet
    
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
        //here i will validate userid and password
        //if valid i will forward you to dashboard
        //else i will forward login page again
        
        //I have to catch userid and password,my user has submitted from the frontend
       String username=request.getParameter("username");
       String password=request.getParameter("password");
        System.out.println(username+" and "+password);
       //so now i need to call a java service in my server or
       //external server
       User myUser=new User();
       myUser.setUsername(username);
       myUser.setPassword(password);
       User valid=UserService.validateLoginCredential(myUser);
        System.out.println("isValidUser: "+valid.isValidUser());
       if(valid.isValidUser()){
           //go todashboard, which is either html or jsp
           String username1=myUser.getUsername();
           
           HttpSession session=request.getSession();
           session.setAttribute("validUser", valid);//why?
           
            //this is the usual way of sending data to front end -html or jsp
           request.getRequestDispatcher("dashboard.jsp").forward(request, response);
       } 
       else{
           //go to login page again
           //we must read from config file
           //go to login page again
           String errorMsg = "Either your userid or password is wrong. Please try again!!";
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
