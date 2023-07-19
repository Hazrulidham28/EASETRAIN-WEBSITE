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
                    <a href="#">Home</a>
                    <a href="#">About us</a>
                    <a href="#">Service</a>
                    <a href="#">Contact</a>
                </nav>
            </header>
        </div>
        <form action = "booktrain" method = "post">
            <div class="container1">
                <h2>Ticket Record:</h2>
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
				    <th>Seat</th>
				  </tr>
				  
               <%
               
               List<historyBean> booking = (List<historyBean>)session.getAttribute("booklist");
               
               for(historyBean books:booking){
            	   
               %>
               
               <tr>
				    <td><%=books.getTrNo()%></td>
              		<td><%=books.getDate() %></td>
				    <td><%=books.getFromStn() %></td>
				    <td><%=books.getToStn() %></td>
				    <td><%=books.getDepTime() %></td>
				    <td><%=books.getArrTime() %></td>
				    <td><%=books.getDuration() %></td>
				    <td><%=books.getType() %></td>
				    <td><%=books.getAmount() %></td>
				    <td><%=books.getSeat() %></td>
				  </tr>
              
              <%} %>
                  
                   
                </table>
                
            </div>
        </form>
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
