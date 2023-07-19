<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    select {
		width: 200px; /* Adjust the width as needed */
		padding: 8px;
		font-size: 16px;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
		background-color: #fff;
	}9

	/* Style for the dropdown arrow */
	select:after {
		content: "\25BC";
		position: absolute;
		top: 12px;
		right: 10px;
		color: #999;
		pointer-events: none;
		}

	/* Style for the dropdown options */
	select option {
		background-color: #fff;
		color: #555;
	}

	/* Style for the dropdown when focused */
	select:focus {
		outline: none;
		border-color: #6c9;
		box-shadow: 0 0 5px rgba(108, 153, 153, 0.5);
	}
	
 
</style>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage - Add Train </title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="addtrain.css">

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
                <a href="#">
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
                <h2 class = "logo">TrainEase - Administration</h2>
            </header>
        </div>
        
        <form action="adminAddTrainServlet" method="POST" onsubmit="return confirm('Are you sure you want to add this train?');">
    <div class="container1">
        <h2>Add Train's Ticket</h2>
        <table>
            <tr>
                <td><label for="train_no">Train No:</label></td>
                <td><input type="text" id="train_no" name="train_no" style="width: 350px; height: 30px; font-size: 12pt" autocomplete="off" required></td>
            </tr>
            <tr>
                <td><label for="departure_station">Departure Station:</label></td>
                <td><input type="text" id="departure_station" name="departure_station" style="width: 350px; height: 30px; font-size: 12pt" autocomplete="off" required></td>
            </tr>
            <tr>
                <td><label for="arrival_station">Arrival Station:</label></td>
                <td><input type="text" id="arrival_station" name="arrival_station" style="width: 350px; height: 30px; font-size: 12pt" autocomplete="off" required></td>
            </tr>
            <tr>
                <td><label for="departure_time">Departure Time:</label></td>
                <td><input type="time" id="departure_time" name="departure_time" required></td>
            </tr>
            <tr>
                <td><label for="arrival_time">Arrival Time:</label></td>
                <td><input type="time" id="arrival_time" name="arrival_time" required></td>
            </tr>
            <tr>
                <td><label for="type">Type:</label></td>
                <td>
                	<select name="type" id="type" required>
                		<option value="silver">Silver</option>
                		<option value="gold">Gold</option>
                		<option value="platinum">Platinum</option>
                	</select>
                </td>
            </tr>
            <tr>
                <td><label for="fare">Fare (RM):</label></td>
                <td><input type="text" class="floatNumberField" id="fare" name="fare" style="height: 30px; font-size: 12pt" autocomplete="off" required /></td>
            </tr>
            <tr>
                <td><label for="date">Date:</label></td>
                <td><input type="date" id="date" name="date" style="height: 30px; font-size: 12pt" required></td>
            </tr>
            <tr>
                <td colspan="2" class="form">
                    <input type="submit" class="submit-btn" value="Add">
                    <input type="reset" class="reset-btn" value="Clear">
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
</html>