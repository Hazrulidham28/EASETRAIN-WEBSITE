<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seating page</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="seatingPage.css">


<style>
	.seat {
		display: flex;
        flex: 0 0 14.28%;
        padding: 5px;
        position: relative;
      }
	      
      .seat label{
		  display:block;
		  position: relative;
		  width:100%;
		  text-align: center;
		  font-size: 14px;
		  font-weight: bolder;
		  line-height: 1.5rem;
		  padding: 4px 0;
		  background: #5bfc60;
		  border-radius: 5px;
		  color: black;
		  width:2.999vw;
	  }
	  
	  .seat label:hover {
  		cursor: pointer;
  		box-shadow: 0 0 0px 2px green;
		}
		
	  .seat input[type=checkbox] {
  		position: absolute;
		}
	  .seat input:focus + label {
  		background: #656e65;
		}
	
		.seat:nth-child(2){
			margin-right: 14%;
		}
		
		
      .booked {
        background: red;
        cursor: not-allowed;
      }
      
      ol{
		  list-style: none;
		  padding: 0;
		  margin:0;
	  }
	  .seats {
		  display:flex;
		  flex-direction: row;
		  flex-wrap: nowrap;
		  justify-content: flex-start;
	  }
	  
	  #seat-container{
		  margin: 20px auto;
		  max-width: 350px;
		  background: rgb(255, 255, 255);
		  border-top-left-radius: 50%;
		  border-top-right-radius: 50%;
		  height: 400px;
	  }
	  
	  .bakul {
		  margin-left: 10%;	
		  padding-left: 70px;
		  padding-top: 10vh;
	  }
	       
      .submit{
		  position: relative;
		  padding: 12px 35px;	
		  background: #FEC195;
		  font-size: 17px;
		  font-weight: 500;
		  color: #181818;
		  border: 3px solid #FEC195;
		  border-radius: 8px;
		  box-shadow: 0 0 0 #fec1958c;
		  transition: all .3s ease-in-out;
	  }
	  
	  .star-1 {
		  position: absolute;
		  top: 20%;
		  left: 20%;
		  width: 25px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all 1s cubic-bezier(0.05, 0.83, 0.43, 0.96);
	}

	.star-2 {
		  position: absolute;
		  top: 45%;
		  left: 45%;
		  width: 15px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
	}

	.star-3 {
		  position: absolute;
		  top: 40%;
		  left: 40%;
		  width: 5px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
	}

	.star-4 {
		  position: absolute;
		  top: 20%;
		  left: 40%;
		  width: 8px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all .8s cubic-bezier(0, 0.4, 0, 1.01);
}

	.star-5 {
		  position: absolute;
		  top: 25%;
		  left: 45%;
		  width: 15px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all .6s cubic-bezier(0, 0.4, 0, 1.01);
	}

	.star-6 {
		  position: absolute;
		  top: 5%;
		  left: 50%;
		  width: 5px;
		  height: auto;
		  filter: drop-shadow(0 0 0 #fffdef);
		  z-index: -5;
		  transition: all .8s ease;
		}

button:hover {
  background: transparent;
  color: #FEC195;
  box-shadow: 0 0 25px #fec1958c;
}

button:hover .star-1 {
  position: absolute;
  top: -80%;
  left: -30%;
  width: 25px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

button:hover .star-2 {
  position: absolute;
  top: -25%;
  left: 10%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

button:hover .star-3 {
  position: absolute;
  top: 55%;
  left: 25%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

button:hover .star-4 {
  position: absolute;
  top: 30%;
  left: 80%;
  width: 8px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

button:hover .star-5 {
  position: absolute;
  top: 25%;
  left: 115%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

button:hover .star-6 {
  position: absolute;
  top: 5%;
  left: 60%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.title{
	padding-left: 9.5vw;
	color:white;
}
.select{
	padding-left: 10vw;
	font-size:20px;
	color:white;
}
.BookSeatDiv{
	margin-top:5vh;
	margin-bottom: 100px;
	display:flex;
	justify-content: right;
	margin-right: 20%;
	
}

.selected-seats{
	margin-top: 10%;
	font-size:20px;
	color:white;
}

.selected-seat{
	font-size:20px;
	color:white;
}

</style>

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
            	<h2 class = "logo">TrainEase</h2>
	        	<nav class = "navigation">
		            <a href ="Home.html">Home</a>
		            <a href ="aboutUs.html">About us</a>
		            <a href ="#">Service</a>
		            <a href ="Contact.html">Contact </a>
	        	</nav>
            </header>
        </div>
          
   		<form method="post" action="seatingServlet">
	<div class="container1">
        <h2>Select your desired seat</h2>
        
	<div class="bakul">
		
		<ol>
			<li>
		      <ol class="seats">
		        <li class="seat">
		          <input type="checkbox" name="btn" value="1A" id="1A"/>
		          <label for="1A">1A</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="1B" id="1B" />
		          <label for="1B">1B</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn"  value="1C" id="1C" />
		          <label for="1C">1C</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn"  value="1D" id="1D"/>
		          <label for="1D">1D</label>
		        </li>
		       
		      </ol>
    		</li>
    		
		    <li>
		      <ol class="seats">
		        <li class="seat">
		          <input type="checkbox" name="btn" value="2A" id="2A" />
		          <label for="2A">2A</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn" value="2B" id="2B"/>
		          <label for="2B">2B</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn" value="2C" id="2C"/>
		          <label for="2C">2C</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="2D" id="2D"/>
		          <label for="2D">2D</label>
		        </li>
		      
		      </ol>
		    </li>
		    
		    <li>
		      <ol class="seats">
		        <li class="seat">
		          <input type="checkbox"name="btn"  value="3A" id="3A"/>
		          <label for="3A">3A</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn"  value="3B" id="3B"/>
		          <label for="3B">3B</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="3C" id="3C"/>
		          <label for="3C">3C</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="3D" id="3D"/>
		          <label for="3D">3D</label>
		        </li>
		       
		      </ol>
		    </li>
		    
		    <li>
		      <ol class="seats">
		        <li class="seat">
		          <input type="checkbox" name="btn" value="4A" id="4A"/>
		          <label for="4A">4A</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn"  value="4B" id="4B"/>
		          <label for="4B">4B</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox"name="btn" value="4C" id="4C" />
		          <label for="4C">4C</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="4D" id="4D"/>
		          <label for="4D">4D</label>
		        </li>
		      
		      </ol>
		    </li>
		    
		    <li>
		      <ol class="seats">
		        <li class="seat">
		          <input type="checkbox" name="btn" value="5A" id="5A"/>
		          <label for="5A">5A</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="5B" id="5B"/>
		          <label for="5B">5B</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="5C" id="5C"/>
		          <label for="5C">5C</label>
		        </li>
		        <li class="seat">
		          <input type="checkbox" name="btn" value="5D" id="5D"/>
		          <label for="5D">5D</label>
		        </li>
		      
		      </ol>
		    </li>
      </ol>
    </div>
    <p class="selected-seats">Selected seat: <span id="selectedSeat"></span></p>
    </div>
    
<div class="BookSeatDiv">
    
    <!--book button-->
    <button class = "submit" onclick="bookSeat()">Book Seat <div class="star-1">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div>
  <div class="star-2">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div>
  <div class="star-3">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div>
  <div class="star-4">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div>
  <div class="star-5">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div>
  <div class="star-6">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
  </div></button>
    
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
      // Add event listeners to the seat elements to handle seat selection
      const seats = document.querySelectorAll(".seat");
      let selectedSeat = null;
      seats.forEach(seat => {
        seat.addEventListener("click", () => {
          if (seat.classList.contains("booked")) {
            alert("Sorry, this seat has already been booked. Please select another seat.");
          } else {
            if (selectedSeat !== null) {
              selectedSeat.classList.remove("selected");
            }
            seat.classList.add("selected");
            selectedSeat = seat;
            document.getElementById("selectedSeat").textContent = seat.textContent;
          }
        });
      });
      
      // Add function to handle seat booking
      function bookSeat() {
        if (selectedSeat === null) {
          alert("Please select a seat before booking.");
        } else {
          selectedSeat.classList.remove("selected");
          selectedSeat.classList.add("booked");
          selectedSeat.removeAttribute("onclick");
          selectedSeat = null;
          document.getElementById("selectedSeat").textContent = "";
          alert("Your seat has been booked successfully.");
        }
      }
</script>
</html>
