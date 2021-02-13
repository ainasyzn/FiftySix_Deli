<%-- 
    Document   : signup
    Created on : 27 Dec 2020, 12:06:32 am
    Author     : Aina Syazana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <!--icons-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="css/style_signup.css">
</head>

<body>
    <div class="main-content">
        <header>
            <div class="website-name">
                <h5>
                    <span>FiftySix Kitchen</span>
                </h5>
            </div>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="menu.jsp">Menu</a></li>
                <li><a href="#contact">About Us</a></li>
                <li><a href="#" class="active">Log in</a></li>
            </ul>
        </header>
       
            <div class="signup-box">
                
                <div class="borang-header">
                    FiftySix Kitchen
                   <form name="signup" action="customerController" method="POST">
                    <div class="borang-content">
                        Full name:
                        <div class="formgap">
                            <input type="text" name="custName"><br>
                        </div>
                        E-mail address:
                        <div class="formgap">
                            <input type="text" name="email"><br>
                        </div>
                        
                        Phone number:
                        <div class="formgap">
                            <input type="text" name="phoneNo"><br>
                        </div>
                        
                        Password:
                        <div class="formgap">
                            <input type="password" name="password"><br>
                        </div>
                        
                        <!--Confirm Password:
                        <div class="formgap">
                            <input type="text" name="confirm-password"><br>
                        </div><br-->
                        
                        
                        <p>Already have an account? <a href="login.jsp">Log in</a></p>
                        
                        <button class="button btn1">Sign up</button>
                    </div>
                   </form>
                </div>
            </div>   
    </div>
</body>
</html>