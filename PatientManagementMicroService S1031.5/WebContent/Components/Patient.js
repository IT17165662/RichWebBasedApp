$(document).ready(function() {
	
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});


// SAVE ---------------------------------------------------


$(document).on("click", "#btnSave", function(event) 
{ 
	//Clear status msges------------------------
	
	$("#alertSuccess").text(""); 
	$("#alertSuccess").hide(); 
	$("#alertError").text(""); 
	$("#alertError").hide(); 
	
	//Form validation---------------------------

	var status = validatePatientForm();
	
	//If not valid------------------------------
	if (status != true) 
	{  
		$("#alertError").text(status);  
		$("#alertError").show(); 
		return; 
	} 
	
	// If valid 
	var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax( 
			{ 
		url : "PatientAPI", 
		type : type,  
		data : $("#formPatient").serialize(),  
		dataType : "text",  
		complete : function(response, status) 
		{   
			onPatientSaveComplete(response.responseText, status); 
			
			} 
	}); 
	
	function onPatientSaveComplete(response, status)
	{ 
		if (status == "success") 
		{  
			var resultSet = JSON.parse(response); 
	 
	  if (resultSet.status.trim() == "success") 
	  {   
		  $("#alertSuccess").text("Successfully saved.");   
	      $("#alertSuccess").show(); 
	 
	   $("#divPatientGrid").html(resultSet.data);  
	   }
	  else if (resultSet.status.trim() == "error")  
	   {   
		   $("#alertError").text(resultSet.data);   
		   $("#alertError").show();  
		   } 
	 
	 } else if (status == "error")
	 {   
		 $("#alertError").text("Error while saving.");  
		 $("#alertError").show(); 
		 } else 
		 { 
			 $("#alertError").text(
					 "Unknown error while saving..");  
			 $("#alertError").show();
			 } 
	 
	 $("#hidPatientIDSave").val(""); 
	 $("#formPatient")[0].reset(true); } 
	
	
});




//UPDATE==========================================
$(document).on("click",".btnUpdate", function(event) {
	
$("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());
$("#m_patient_id").val($(this).closest("tr").find('td:eq(1)').text());
$("#m_patient_userName").val($(this).closest("tr").find('td:eq(2)').text());
$("#m_patient_password").val($(this).closest("tr").find('td:eq(3)').text());
$("#m_patient_name").val($(this).closest("tr").find('td:eq(4)').text());
$("#m_patient_birthDate").val($(this).closest("tr").find('td:eq(5)').text());
$("#m_patient_weight").val($(this).closest("tr").find('td:eq(6)').text());
$("#m_patient_bloodGroup").val($(this).closest("tr").find('td:eq(7)').text());
$("#m_patient_contactNo").val($(this).closest("tr").find('td:eq(8)').text());
$("#m_patient_address").val($(this).closest("tr").find('td:eq(9)').text());
$("#m_patient_gurdianName").val($(this).closest("tr").find('td:eq(10)').text());
$("#m_patient_age").val($(this).closest("tr").find('td:eq(11)').text());
});



//REMOVE-------------------------------------------------- 


$(document).on("click", ".btnRemove", function(event)
		{ 
	$.ajax( 
			{  
				url : "PatientAPI",   
				type : "DELETE",   
				data : "t_payment_no=" + $(this).data("t_payment_no"),   
				dataType : "text",   
				complete : function(response, status)   
				{    
					onPatientDeleteComplete(response.responseText, status);   
					}  
			});
	});
function onPatientDeleteComplete(response, status)
{ 
	
	if (status == "success")
	{  
		var resultSet = JSON.parse(response); 

if (resultSet.status.trim() == "success")  
{    
	$("#alertSuccess").text("Successfully deleted.");    
	$("#alertSuccess").show(); 

 $("#divPatientGrid").html(resultSet.data);   
 } 
else if (resultSet.status.trim() == "error")  
{    
	$("#alertError").text(resultSet.data);    
	$("#alertError").show();  
	} 

}
	else if (status == "error")  
{  
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
		} 
	else  
	{   
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show(); 
		}
	} 

// Client-Model------------------------------------------
function validatePatientForm() 
{  
	//ID  
	if ($("#m_patient_id").val().trim() == "")  
	{   
		return "Insert patient id.";  
	} 
	//USERNAME
	if ($("#m_patient_userName").val().trim() == "")  
	{   
		return "Insert username.";  
	} 
	//PASSWORD
	if ($("#m_patient_password").val().trim() == "")  
	{   
		return "Insert password.";  
	} 
	//NAME
	if ($("#m_patient_name").val().trim() == "")  
	{   
		return "Insert name.";  
	} 
	//BIRTHDATE
	if ($("#m_patient_birthDate").val().trim() == "")  
	{   
		return "Insert birthDate.";  
	}
	//WEIGHT
	if ($("#m_patient_weight").val().trim() == "")  
	{   
		return "Insert weight.";  
	}
	 // BLOODGROUP  
	if ($("#m_patient_bloodGroup").val() === "0")  
	{   
		return "Select bloodGroup.";  
	} 
	//CONTACTNO
	if ($("#m_patient_contactNo").val().trim() == "")  
	{   
		return "Insert contactNo.";  
	}
	//ADDRESS
	if ($("#m_patient_address").val().trim() == "")  
	{   
		return "Insert address.";  
	}
	//GURDIANNAME
	if ($("#m_patient_gurdianName").val().trim() == "")  
	{   
		return "Insert gurdianName.";  
	}
	//AGE
	if ($("#m_patient_age").val().trim() == "")  
	{   
		return "Insert age.";  
	}
	
	 
	return true; 
}

