<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



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
            <img src="https://drive.google.com/uc?export=view&id=19qPXXg7Q2ua0oHZEaEG0PXnMg0C704Hy" alt="customer" class="user-img">
            <div>
                <p class="bold">Hadi</p>
                <p>Wallet: RM0.00</p>
            </div>
        </div>
        <ul>
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
                    <a href="Homepage.jsp">Home</a>
                    <a href="#">About us</a>
                    <a href="#">Service</a>
                    <a href="#">Contact</a>
                </nav>
            </header>
        </div>
        <form>
            <div class="container1">
                <h2>Book your Ticket:</h2>
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
                    
                  
                   
                </table>
                <button type="submit" class="submit-btn">Proceed</button>
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
</body>
</html>
