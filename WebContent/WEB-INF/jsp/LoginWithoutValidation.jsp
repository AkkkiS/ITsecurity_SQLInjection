<!DOCTYPE html>

<html>


<head>


<script
	src="../js/jQuery.js"></script>
	
	
<script
	src="../js/JQuery-UI.js"></script> 
  
 
<link rel='stylesheet' href='../css/JQuery-css.css'>

    
<link rel="stylesheet" href="../css/loginPagestyle.css" media="screen" type="text/css" />

<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 50px;
  height: 50px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
  margin : 160px 0 0 580px;
  position: absolute;
  display: none;
  z-index: 1000;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
  
  <script>
	$(document).ready(function() {

		$("#register").click(function() {
			
			if( $("#userName").val() == "" ){
				
				alert("Enter Username");
			}else if( $("#password").val() == "" ){
				
				alert("Enter password");
			}else{
				
				$(".loader").show();
				
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/ITSecurity_SQLInjection/ITSec/insertUser",
					data : JSON.stringify({
						"userName" : $("#userName").val(),
						"userPassword" : $("#password").val()
					}),
					success : function(data) {
						
						$(".loader").hide();
						
						alert(data);		
					},				
					error: function(XMLHttpRequest, textStatus, errorThrown) { 
						$(".loader").hide();
				    } 

				});
				
			}

			
		});

		$("#submit").click(function() {
			
			if( $("#userName").val() == "" ){
				
				alert("Enter Username");
			}else if( $("#password").val() == "" ){
				
				alert("Enter password");
			}else{
				
				$(".loader").show();
				
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/ITSecurity_SQLInjection/ITSec/checkUser",
					data : JSON.stringify({
						"userName" : $("#userName").val(),
						"userPassword" : $("#password").val()
					}),
					success : function(data) {
						
						$(".loader").hide();
						
						if( data == 1 ){
							
							
							location.replace("/ITSecurity_SQLInjection/ITSec/getDataTableWithoutValidation");
							
						}else if( data == 0 ){
							
							alert("Invalid Credentials");
							
						}else if( data == -1 ){
							
							alert("User doesn't exist. Please register");
						}

						

					},				
					error: function(XMLHttpRequest, textStatus, errorThrown) { 
						$(".loader").hide();
				    } 

				});
				
			}
			
		});
		

	});
  </script>


  <title>
Log-in
</title>


</head>


<body>

  <div class="loader"></div>

  <div class="login-card">
    
<h1>Log-in</h1><br>
    <input id="userName" type="text" name="user" placeholder="Username">
    <input id="password" type="password" name="pass" placeholder="Password">
    <input id="submit"   type="submit" name="login" class="login login-submit" value="login">


  <div class="login-help">
    <a id="register" href="#">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Forgot Password</a>
  </div>
</div>

</body>

</html>