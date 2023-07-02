<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="Bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="Payment.css">
</head>
<body>
    <div class="sidebar">
        <div class="top">
            <br><br><br>
            <i class="bx bx-menu" id="btn"></i>
        </div>
        <div class="user">
            <img src="https://drive.google.com/uc?export=view&id=19qPXXg7Q2ua0oHZEaEG0PXnMg0C704Hy" alt="customer" class="user-img">
            <div>
                <p class="bold"><%=session.getAttribute("uName") %></p>
            </div>
        </div>
        <ul>
            <li>
                <a href="#">
                    <i class="bx bxs-grid-alt"></i>
                    <span class="nav-item">Dashboard</span>
                </a>
                <span class="tooltip">Dashboard</span>
            </li>
            <li>
                <a href="#">
                    <i class="bx bx-id-card"></i>
                    <span class="nav-item">Profile</span>
                </a>
                <span class="tooltip">Profile</span>
            </li>
            <li>
                <a href="#">
                    <i class="bx bxs-shopping-bag"></i>
                    <span class="nav-item">BuyTicket</span>
                </a>
                <span class="tooltip">Buy</span>
            </li>
            <li>
                <a href="#">
                    <i class="bx bxs-food-menu"></i>
                    <span class="nav-item">HistoryTicket</span>
                </a>
                <span class="tooltip">History</span>
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
                    <a href="#">Home</a>
                    <a href="#">About us</a>
                    <a href="#">Service</a>
                    <a href="#">Contact</a>
                </nav>
            </header>
        </div>
        <div id="Parent-Order-Container">
            <div id="Title-Container">
                <h1>Order Details</h1>
            </div>
            
            <%
            customerBean customer=(customerBean) application.getAttribute("currCust");
            trainBean train=(trainBean) application.getAttribute("trainBook");
            
            %>
            <div id="passenger">
                <p id="LittleTitle">Passenger Detail</p>
                <p>Name: <%=customer.getUsername() %></p>
                <p>MyKad No: <%=customer.getIcnum() %></p>
                <p>Contact No:<%=customer.getPhoneNum() %></p>
            </div>
            <div id="ticketDetail">
                <p><%=train.getFromStn() %>> <%=train.getToStn() %></p>
                <p><%=train.getType() %> - <%=train.getTrNo() %></p>
                <p><%=train.getDate() %> / <%=train.getDepTime() %></p>
            </div> 
            <div id="orderSummary">
                <p id="LittleTitle">Order Summary</p>
                <p>Total</p>
                <p>MYR <%=train.getFare() %></p>
            </div>
            <h1 class="paymentTitle">Payment Options</h1>
            
            <div class="payment-container">
                <!-- submit the payment option to the database -->
                <form action="createReserveServlet" method="post">
                    <div class="wrapper">
                        <div class="option">
                            <input class="input" type="radio" name="btn" value="Train Wallet" checked="">
                            <div class="btn">
                                <span class="span">Train Wallet</span>
                            </div>
                        </div>
                        <div class="option">
                            <input class="input" type="radio" name="btn" value="Debit Card">
                            <div class="btn">
                                <span class="span">Debit Card</span>
                            </div>
                        </div>
                        <div class="option">
                            <input class="input" type="radio" name="btn" value="Credit Card">
                            <div class="btn">
                                <span class="span">Credit Card</span>
                            </div>
                        </div>
                        <div class="option">
                            <input class="input" type="radio" name="btn" value="Touch N Go">
                            <div class="btn">
                                <span class="span">TNG</span>
                            </div>
                        </div>
                    </div>
                    <input class="submit" type="submit" value="Proceed"> 
                </form>
            </div>
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
