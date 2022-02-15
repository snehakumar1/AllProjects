<%-- 
    Document   : registration
    Created on : 03-Jan-2022, 8:30:47 pm
    Author     : Lenovo
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
    <head>
        <title>Inventory Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css">
    </head>
    
    <body>
        <div class="login-page">
  <div class="form">
<!--    <form  action="RegistrationServlet" method="post" class="register-form">
      <input type="text" name="username" value="" placeholder="name"/>
      <input type="password" name="password" placeholder="password"/>
      <input type="text" name="firstName" value="" placeholder="First Name"/>
      <input type="text" name="lastName" value="" placeholder="Last Name"/>
      <input type="text" name="email" value="" placeholder="email address"/>
      <input type="text" name="phone" value="" placeholder="Phone No"/>
      <button>create</button>-->
<!--      <p class="message">Already registered? <a href="#">Sign In</a></p>-->
    </form>
    <form action="CreateUserServlet" method="post" class="login-form">
      <input type="text" name="username" value="" placeholder="name"/>
      <input type="password" name="password" placeholder="password"/>
      <input type="text" name="firstName" value="" placeholder="First Name"/>
      <input type="text" name="lastName" value="" placeholder="Last Name"/>
      <input type="text" name="email" value="" placeholder="email address"/>
      <input type="text" name="phone" value="" placeholder="Phone No"/>
      <button type="submit">create</button>
    </form>
<div>
<!--     here I want to display my error msg after extracting from request 
        also need to format in red colour. in order to use request object(java object) we need to use something jstl=java server tag library
        why? because it helps us reduce no. of lines of code
        -->
        <div class="isa_error">
            <c:out value="${ErrorMsg}"/>  
        </div>
        
</div>
  </div>
</div>
        <script src="js/login.js"></script>
    </body>
</html>

