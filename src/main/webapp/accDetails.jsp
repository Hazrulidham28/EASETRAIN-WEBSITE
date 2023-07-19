<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*" %>
<%@page import="Utility.*" %>
<!DOCTYPE html>
<html lang="en">
<head>

<style>

    table {
        width: 100%;
        border-collapse: collapse;
        
    }
    table td {
        padding: 10px;
    }
    
	
 
</style>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="accDetails.css">

</head>
 <%
            customerBean customer=(customerBean) application.getAttribute("currentCustomer");
 			String username=customer.getUsername();
            
  %>
<body>
	<div class="sidebar">
	
        <div class="top">
        	<br><br><br>
        	<i class="bx bx-menu" id="btn"></i>
        </div>
        
        <div class="user">
        	<img src="https://drive.google.com/uc?export=view&id=15U6MiCsN2LLipUjcOmvo4BWET61Cbr7H" alt="customer" class="user-img">
            <div>
                <p class="bold"><%=session.getAttribute("uName")%></p>
            </div>
        </div>
        
        <ul>
            <li>
                <a href="userViewAccount">
                    <i class="bx bx-id-card"></i>
                    <span class="nav-item">Profile</span>
                </a>
                <span class="tooltip">Profile</span>
            </li>
            <li>
                <a href="userviewtrain">
                    <i class="bx bxs-shopping-bag"></i>
                    <span class="nav-item">BuyTicket</span>
                </a>
                <span class="tooltip">Buy</span>
            </li>
            <li>
                <a href="userviewRecord">
                    <i class="bx bxs-food-menu"></i>
                    <span class="nav-item">HistoryTicket</span>
                </a>
                <span class="tooltip">History</span>
            </li>
            <li>
                <a href="userLogoutServlet">
                    <i class="bx bx-log-out"></i>
                    <span class="nav-item">LogOut</span>
                </a>
                <span class="tooltip">Logout</span>
            </li>
        </ul>
        
    </div>

    <div class="main-content">
    
       <div class="container">
            <header>
                <h2 class="logo">TrainEase</h2>
                <nav class="navigation">
                    <a href="Home.html">Home</a>
                    <a href="#">About us</a>
                    <a href="#">Service</a>
                    <a href="#">Contact</a>
                </nav>
            </header>
        </div>
        
        <form action="userUpdateAcc" method="POST" onsubmit="return confirm('Confirm your details>');">
    <div class="container1">
        <h2>Manage your profile</h2>
        <table>
            <tr>
                <td style="width: 20%"><label for="uname" style="font-size: 14pt">Name:</label>
                <td><input type="text" id="uname" name="uname" autocomplete="off" value="<%=username%>"></td>
            </tr>
            <tr>
                <td><label for="Icno" style="font-size: 14pt">Identity Card number:</label></td>
                <td><input type="text" id="Icno" name="Icno" autocomplete="off" readonly value="<%=customer.getIcnum()%>"></td>
            </tr>
            <tr>
                <td><label for="email" style="font-size: 14pt">E-mail:</label></td>
                <td><input type="text" id="email" name="email" autocomplete="off" value="<%=customer.getEmail() %>"></td>
            </tr>
            <tr>
                <td><label for="phonenum" style="font-size: 14pt">Phone Number:</label></td>
                <td><input type="text" id="phonenum" name="phonenum" autocomplete="off" value="<%=customer.getPhoneNum() %>"></td>
            </tr>

            <tr>
                <td colspan="2" class="form">
                    <button type="submit" class="submit-btn">Update</button>
                </td>
            </tr>
        </table>
    </div>
</form>	
    </div>

</body>

<script>
    let btn = document.querySelector('#btn');
    let sidebar = document.querySelector('.sidebar');

    btn.onclick = function () {
        sidebar.classList.toggle('active');
    };
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".floatNumberField").change(function() {
            $(this).val(parseFloat($(this).val()).toFixed(2));
        });
    });
</script>
<%int update=(int)session.getAttribute("updateSuccess"); %>

<% 
if (update == 1) {
%>
<script>
  alert("Successfully update!");
</script>
<% } else if (update == 2) { %>
<script>
  alert("Failed to update!");
</script>
<% } %>
<%session.setAttribute("updateSuccess",0); %>
</html>