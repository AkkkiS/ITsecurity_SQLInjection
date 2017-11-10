<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form Design</title>

<script
	src="../js/jQuery.js"></script>
	
	
<link rel="stylesheet" href="../css/styleSearch.css" />


<link rel="stylesheet" href="../css/stylesheet-pure-css.css" />


<script src="../js/JQuery-dataTable.js"></script>

<link rel="stylesheet" href="../css/JQuery-dataTable-UI.css">

<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 50px;
  height: 50px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
  margin : 200px 0 0 580px;
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
	
	var table;

	$("#submitSearch").click(function() {
				
		if( $('#searchString').val() == "" ){
			
			alert(" Type in something to search ");
			
		}else if( !/^[0-9*]+$/.test( $('#searchString').val() ) && $('input[name="radio"]:checked').val() == "1"){
			
			alert(" Customer id has to be numerical ");
			
		}else{
			
			$(".loader").show();
			
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/ITSecurity_SQLInjection/ITSec/searchForDataTableWithoutValidation",
				data : JSON.stringify({
					"searchString" : $('#searchString').val(),
					"searchType" : $('input[name="radio"]:checked').val()
				}),
				success : function(dataSet) {
					
					$(".loader").hide();
					
					table.destroy();
					
			        $('#example').empty();
					
					if( dataSet != null ){					
				        
				        table = $('#example').DataTable( {
					        data: dataSet,
					        columns: [
					                  { title: "Customer Id" },
					                  { title: "First name" },
					                  { title: "Last name" },
					                  { title: "City" },
					                  { title: "County" },
					                  { title: "State" },
					                  { title: "Country" },
					                  
					              ]
					    } );
					}else{
						
						table = $('#example').DataTable( {
			                data: [],
			                columns: [
			                    { title: "Customer Id" },
			                    { title: "First name" },
			                    { title: "Last name" },
			                    { title: "City" },
			                    { title: "County" },
			                    { title: "State" },
			                    { title: "Country" },
			                    
			                ]
			            } );
						
						
					}
					

				},				
				error: function(XMLHttpRequest, textStatus, errorThrown) { 
					$(".loader").hide();
			    } 

			});
			
		}

		
	});	
	
	
	table = $('#example').DataTable( {
        data: [],
        columns: [
            { title: "Customer Id" },
            { title: "First name" },
            { title: "Last name" },
            { title: "City" },
            { title: "County" },
            { title: "State" },
            { title: "Country" },
            
        ]
    } );
	
})





</script>

</head>

<body>

	<div class="loader"></div>

	<div id="search-form">
		<div class="form-container">
			<input id="searchString" type="text" class="search-field" value="" />
			<div class="submit-container">
				<input id="submitSearch" type="submit" value="" class="submit" />
			</div>
		</div>

		<div class="example">
			<div>
				<input id="radio1" type="radio" name="radio" value="1"
					checked="checked"><label for="radio1"><span><span></span></span>Customer
					Id</label>
			</div>
			<div>
				<input id="radio2" type="radio" name="radio" value="2"><label
					for="radio2"><span><span></span></span>First Name</label>
			</div>
		</div>


	</div>
		
	
	<div>
      <table id="example" class="display"></table>
    </div>


	<!-- <script src="js/index.js"></script> -->

</body>
</html>
