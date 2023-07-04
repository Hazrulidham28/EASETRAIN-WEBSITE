<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
<style>

.form-container {
    position: relative;
    background: url('https://drive.google.com/uc?export=view&id=11w9e1lceHimEOlv7RFmjWKw2jUkun0JM') no-repeat;
    background-attachment: fixed;
    min-height: 100vh;
    top: 0;
    left: 80px;
    transition: all 0.5s ease;
    width: calc(100% - 80px);
    padding: 1rem;
    background-size: cover;
    
}
.form {
    color: white;
    padding: 3.5vw;
    margin-top: 5vh;
    margin-left: 10vw;
    margin-right: 10vw;
    min-height: 65vh;
    min-width: 50vw;
    background-color: #12171e;
    border-radius: 30px;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
}

.center {
  
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 10px;
}
</style>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="ticketRecord.css">

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
                <p class="bold">admin</p>
                
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
<div class="form-container">
	<div class ="form">
	<div class="center">
  <form action="" method="POST">
    <label for="train_name">Train No:</label>
    <input type="text" id="train_no" name="train_no" required><br><br>
    
    <label for="departure_station">Departure Station:</label>
    <input type="text" id="departure_station" name="departure_station" required><br><br>
    
    <label for="arrival_station">Arrival Station:</label>
    <input type="text" id="arrival_station" name="arrival_station" required><br><br>
    
    <label for="departure_time">Departure Time:</label>
    <input type="time" id="departure_time" name="departure_time" required><br><br>
    
    <label for="arrival_time">Arrival Time:</label>
    <input type="time" id="arrival_time" name="arrival_time" required><br><br>
    
    <input type="submit" value="Add Train">
  </form>
  </div>
  </div>
  </div>

</body>

<script>
    let btn = document.querySelector('#btn');
    let sidebar = document.querySelector('.sidebar');

    btn.onclick = function () {
        sidebar.classList.toggle('active');
    };
</script>
</html>