<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="Bean.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buy Ticket</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="Buyticket.css">
</head>
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
                <p></p>
            </div>
        </div>
        <ul>
            <li>
                <a href="adminviewtrain">
                    <i class="bx bx-id-card"></i>
                    <span class="nav-item">View Train</span>
                </a>
                <span class="tooltip">View</span>
            </li>
            <li>
                <a href="userviewtrain">
                    <i class="bx bxs-shopping-bag"></i>
                    <span class="nav-item">Add Train</span>
                </a>
                <span class="tooltip">Add</span>
            </li>
            <li>
                <a href="userviewRecord">
                    <i class="bx bxs-food-menu"></i>
                    <span class="nav-item">Update Train</span>
                </a>
                <span class="tooltip">Update</span>
            </li>
             <li>
                <a href="userviewRecord">
                    <i class="bx bxs-food-menu"></i>
                    <span class="nav-item">Delete Train</span>
                </a>
                <span class="tooltip">Delete</span>
            </li>
            <li>
                <a href="#">
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
        
            <div class="container1">
                <h2>Train List:</h2>
                <table border="2">
				  <tr>
				    <th>Train Code</th>
				    <th>Date</th>
				    <th>Origin Station</th>
				    <th>Destination Station</th>
				    <th>Departure Time</th>
				    <th>Arrival Time</th>
				    <th>Duration</th>
				    <th>Type</th>
				    <th>Fare</th>
				  </tr>
				  
               <%
               List<trainBean>train=(List<trainBean>)session.getAttribute("trains");
               
               for(trainBean trains:train){
            	   
               %>
               
               <tr>
				    <td><%=trains.getTrNo()%></td>
              		<td><%=trains.getDate() %></td>
				    <td><%=trains.getFromStn() %></td>
				    <td><%=trains.getToStn() %></td>
				    <td><%=trains.getDepTime() %></td>
				    <td><%=trains.getArrTime() %></td>
				    <td><%=trains.getDuration() %></td>
				    <td><%=trains.getType() %></td>
				    <td><%=trains.getFare() %></td>
				  </tr>
              
              <%} %>
                  
                   
                </table>
                
            </div>
        
    </div>

    <script>
        let btn = document.querySelector('#btn');
        let sidebar = document.querySelector('.sidebar');

        btn.onclick = function () {
            sidebar.classList.toggle('active');
        };
    </script>
</body>
</html>
