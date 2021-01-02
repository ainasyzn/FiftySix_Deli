<%-- 
    Document   : manage-user
    Created on : 2 Jan 2021, 5:11:34 pm
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css">
    <link rel="stylesheet" href="../css/dashboard.css">
</head>

<body>  
    <div class="sidebar">
        <div class="sidebar-user">
            <img src="../image/fox.png">
            <div class="user-image">
                <p>Admin</p>
            </div>
        </div>
        <div class="sidebar-menu">
            <hr>
            <ul>
                <li><a href="index.jsp"><span>Home</span></a></li>
                <li><a href="manage-menu.jsp"><span>Manage Menu</span></a></li>
                <li class="active"><a href="#"><span>Manage User</span></a></li>
                <li><a href="manage-order.jsp"><span>Manage Order</span></a></li>
                <li><a href="report.jsp"><span>Report</span></a></li>
                <li><a href=""><span>Logout</span></a></li>
            </ul>
        </div>
    </div>

    <div class="main-content">
        <header>
            <div class="website-name">
              <h5>
                <span>FiftySix Kitchen</span>
              </h5>
            </div>
        </header>  
        <main>
    <div class="cctabs">
      <input checked id="one" name="tabs" type="radio">
      <label for="one"></i>List of Riders</label>
      <input id="two" name="tabs" type="radio" value="Two">
      <label for="two">List of Customers</label>
      
      <div class="panels">
        <div class="panel">
          table 1
        </div>
        <div class="panel">
          table 2
        </div>
          
        </div>
      </div>
    </div>
  </div>
        </main>    
    </div>
    
</body>
</html>
