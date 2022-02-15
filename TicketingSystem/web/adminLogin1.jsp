<%-- 
    Document   : adminLogin1
    Created on : 1 Feb, 2022, 3:56:17 PM
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                /*background-color: #adad85;*/
                background-image: url("https://images.squarespace-cdn.com/content/v1/5d4cfd87082420000108b311/1566718849902-809OYSILCPJLAKT97XWE/futuristic-technology-abstract-background-beautiful-footage-087637197_prevstill.jpeg?format=2500w");
                font-family: "Asap", sans-serif;
            }

            .login {
                overflow: hidden;
                background-color: white;
                padding: 40px 30px 30px 30px;
                border-radius: 10px;
                position: absolute;
                top: 50%;
                left: 50%;
                width: 400px;
                -webkit-transform: translate(-50%, -50%);
                -moz-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                -o-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                -webkit-transition: -webkit-transform 300ms, box-shadow 300ms;
                -moz-transition: -moz-transform 300ms, box-shadow 300ms;
                transition: transform 300ms, box-shadow 300ms;
                box-shadow: 5px 10px 10px rgba(2, 128, 144, 0.2);
            }
            .login::before, .login::after {
                content: "";
                position: absolute;
                width: 600px;
                height: 600px;
                border-top-left-radius: 40%;
                border-top-right-radius: 45%;
                border-bottom-left-radius: 35%;
                border-bottom-right-radius: 40%;
                z-index: -1;
            }
            .login::before {
                left: 40%;
                bottom: -130%;
                background-color: rgba(69, 105, 144, 0.15);
                -webkit-animation: wawes 6s infinite linear;
                -moz-animation: wawes 6s infinite linear;
                animation: wawes 6s infinite linear;
            }
            .login::after {
                left: 35%;
                bottom: -125%;
                background-color: rgba(2, 128, 144, 0.2);
                -webkit-animation: wawes 7s infinite;
                -moz-animation: wawes 7s infinite;
                animation: wawes 7s infinite;
            }
            .login > input {
                font-family: "Asap", sans-serif;
                display: block;
                border-radius: 5px;
                font-size: 16px;
                background: white;
                width: 100%;
                border: 0;
                padding: 10px 10px;
                margin: 15px -10px;
            }
            .login > button {
                font-family: "Asap", sans-serif;
                cursor: pointer;
                color: #fff;
                font-size: 16px;
                text-transform: uppercase;
                width: 80px;
                border: 0;
                padding: 10px 0;
                margin-top: 10px;
                margin-left: -5px;
                border-radius: 5px;
                background-color: #050505;
                -webkit-transition: background-color 300ms;
                -moz-transition: background-color 300ms;
                transition: background-color 300ms;
            }
            .login > button:hover {
                background-color: #383837;
            }

            @-webkit-keyframes wawes {
                from {
                    -webkit-transform: rotate(0);
                }
                to {
                    -webkit-transform: rotate(360deg);
                }
            }
            @-moz-keyframes wawes {
                from {
                    -moz-transform: rotate(0);
                }
                to {
                    -moz-transform: rotate(360deg);
                }
            }
            @keyframes wawes {
                from {
                    -webkit-transform: rotate(0);
                    -moz-transform: rotate(0);
                    -ms-transform: rotate(0);
                    -o-transform: rotate(0);
                    transform: rotate(0);
                }
                to {
                    -webkit-transform: rotate(360deg);
                    -moz-transform: rotate(360deg);
                    -ms-transform: rotate(360deg);
                    -o-transform: rotate(360deg);
                    transform: rotate(360deg);
                }
            }
            a {
                text-decoration: none;
                color: rgba(255, 255, 255, 0.6);
                position: absolute;
                right: 10px;
                bottom: 10px;
                font-size: 12px;
            }
        </style>
    </head>
    <body>
        <form id="Login" action="loginadmin" method="post">

            <div class="login">
                <input type="email" name="adminEmail" placeholder="Email">
                <input type="password" name="adminPassword" placeholder="Password">
                <button>Login</button>
            </div>
        </form>

        <!--<a href="https://codepen.io/davinci/" target="_blank">check my other pens</a>-->    
    </body>
</html>
