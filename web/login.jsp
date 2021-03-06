<%-- 
    Document   : login
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
    <link rel="stylesheet" href="css/style.css">
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
       
            <div class="login-box">
                <img src="image/login.jpg">
                
                <div class="borang-header">
                    FiftySix Kitchen
                    <hr>
                    <div class="sub">
                        Log in
                    </div>
                    <div class="borang-content">
                        Username:
                        <div>
                            <input type="text" name="username">
                        </div><br>
                        
                        Password:
                        <div>
                            <input type="password" name="pasword">
                        </div><br>
                        
                        <p>Don't have an account yet? <a href="signup.jsp">Sign up</a></p>
                        
                        <button class="button btn1">Log in</button>
                    </div>
                </div>
            </div>
        
    </div>
</body>
</html>