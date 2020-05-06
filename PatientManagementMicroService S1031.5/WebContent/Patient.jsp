<%@page import="com.model.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.2.1.min.js"></script> 
<script src="Components/Patient.js"></script> 
</head>
<body>
	<div class="container"> 
 
  		<div class="row">    
  			<div class="col-8"> 
 
    			<h1 class="m-3">Patient Form</h1> 
 
    			<form id="formPatient"> 
    			
    				<!-- PATIENTID --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">ID: </span>  
    					</div>  
    					<input type="text" id="m_patient_id" name="m_patient_id"> 
    				</div>
    				
    				<!-- USERNAME --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">UserName: </span>  
    					</div>  
    					<input type="text" id="m_patient_userName" name="m_patient_userName"> 
    				</div>
    				
    				<!--PASSWORD --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">Password: </span>  
    					</div>  
    					<input type="text" id="m_patient_password" name="m_patient_password"> 
    				</div>
    				
    				<!-- NAME --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">Name: </span>  
    					</div>  
    					<input type="text" id="m_patient_name" name="m_patient_name"> 
    				</div>
    				 
    				<br>
    				<!-- BIRTHDATE --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">BirthDate: </span>  
    					</div>
    					<input type="date" id="m_patient_birthDate" name="m_patient_birthDate">  
    				</div>
    				
    				<!-- WEIGHT --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">Weight: </span>  
    					</div>  
    					<input type="text" id="m_patient_weight" name="m_patient_weight"> 
    				</div>
    				
    				<br>
    				<!-- BLOODGROUP --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">BloodGroup: </span>  
    					</div>  
    					       <input type="text" id="m_patient_bloodGroup" name="m_patient_bloodGroup"> 
    				</div>
    				
    				<!-- CONTACTNO --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">ContactNo: </span>  
    					</div>  
    					<input type="text" id="m_patient_contactNo" name="m_patient_contactNo"> 
    				</div>
    				
    				<!-- ADDRESS --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">Address: </span>  
    					</div>  
    					<input type="text" id="m_patient_address" name="m_patient_address"> 
    				</div>
    				<!-- GURDIANNME --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">GurdianName: </span>  
    					</div>  
    					<input type="text" id="m_patient_gurdianName" name="m_patient_gurdianName"> 
    				</div>
    				
    				<!-- AGE --> 
    				<div class="input-group input-group-sm mb-3">  
    					<div class="input-group-prepend">   
    						<span class="input-group-text" id="lblName">Age: </span>  
    					</div>  
    					<input type="text" id="m_patient_age" name="m_patient_age"> 
    				</div>
    		
    				
    				<br>
    				<div id="alertSuccess" class="alert alert-success"></div>   
    				<div id="alertError" class="alert alert-danger"></div> 
 
 
 	
	   <input type="button" id="btnSave" value="Save" class="btn btn-primary">
	   <input type="hidden" id="hidPatientIDSave" name="hidPatientIDSave" value="">
	 </form>
	  <div id="alertSuccess" class="alert alert-success"></div>
 		    <div id="alertError" class="alert alert-danger"></div>
 <br>
 <div id="divPatientGrid">
 <%
                  Patient Patientobj = new Patient();
                  out.print(Patientobj.readPatient());
                 %>
 </div>
 </div>
 </div>
 </div>
</body>
</html>