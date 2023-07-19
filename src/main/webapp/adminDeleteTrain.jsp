<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="Bean.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Train</title>
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
        	<img src="https://drive.google.com/uc?export=view&id=1ZfUQaSE0rfmcv53bGHHDXFp6m71A6m5c" alt="customer" class="user-img">
            <div>
                <p class="bold">Admin</p>
            </div>
        </div>
        
        <ul>
            <li>
                <a href="adminviewtrain">
                    <i class='bx bx-file-find' ></i>
                    <span class="nav-item">ViewTrain</span>
                </a>
                <span class="tooltip">View</span>
            </li>
            <li>
                <a href="adminaddtrain.jsp">
                    <i class='bx bx-add-to-queue' ></i>
                    <span class="nav-item">AddTrain</span>
                </a>
                <span class="tooltip">Add</span>
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-edit' ></i>
                    <span class="nav-item">UpdateTrain</span>
                </a>
                <span class="tooltip">Update</span>
            </li>
            <li>
                <a href="adminDeleteTrainServlet">
                    <i class='bx bxs-trash' ></i>
                    <span class="nav-item">DeleteTrain</span>
                </a>
                <span class="tooltip">Delete</span>
            </li>
            <li>
                <a href="adminLogoutServlet">
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
        <form action = "adminDeleteTrain" method = "post" onsubmit="return confirm('Are you sure you want to delete this train?');">
            <div class="container1">
                <h2>Choose 1 Train:</h2>
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
				    <td><input type="checkbox" name="train" value="<%=trains.getTrNo()%>"><%=trains.getTrNo() %> </td>
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
                <button type="submit" class="submit-btn">Delete</button>
                <button type="reset" class="reset-btn">Reset</button>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	    $(document).ready(function () {
	        $(".floatNumberField").change(function() {
	            $(this).val(parseFloat($(this).val()).toFixed(2));
	        });
	    });
	</script>
</body>
</html>
