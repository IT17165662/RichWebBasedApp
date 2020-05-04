package com.controller;

import java.sql.Date;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.Parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.google.gson.*;



import com.model.Patient;



@Path("/Patient")
public class PatientService {

	
	
	Patient PatientObj = new Patient();


	@GET
	@Path("/")
	@Produces(MediaType.TEXT_XML)
	public String readPatient() {

		return "From  Patient";
	}
	
	
	@POST
	@Path("/Login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String PatientLogin(String PatientDetails) {
		String output="";
		Patient patient = new Patient();
		String outPut = "";
		
		JsonObject loginObject = new JsonParser().parse(PatientDetails).getAsJsonObject();
		
		
		String Uname = loginObject.get("userName").getAsString();
		String password = loginObject.get("password").getAsString();
		
		output = patient.PatientLogin(Uname, password);
		
return output;		
		
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(String patientData) {

		// Convert the input string to a JSON object
		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject();
		
		// Read the values from the JSON object
		String m_patient_id = patientObject.get("m_patient_id").getAsString();
		String m_patient_userName = patientObject.get("m_patient_userName").getAsString();
		String m_patient_password = patientObject.get("m_patient_password").getAsString();
		String m_patient_name = patientObject.get("m_patient_name").getAsString();
		String m_patient_birthDate = patientObject.get("m_patient_birthDate").getAsString();
		Double m_patient_weight = patientObject.get("m_patient_weight").getAsDouble();
		String m_patient_bloodGroup = patientObject.get("m_patient_bloodGroup").getAsString();
		int m_patient_contactNo = patientObject.get("m_patient_contactNo").getAsInt();
		String m_patient_address = patientObject.get("m_patient_address").getAsString();
		String m_patient_gurdianName = patientObject.get("m_patient_gurdianName").getAsString();
		int m_patient_age = patientObject.get("m_patient_age").getAsInt();
		
		String output = PatientObj.insertPatient(m_patient_id,m_patient_userName,m_patient_password,m_patient_name, Date.valueOf(m_patient_birthDate), m_patient_weight, m_patient_bloodGroup, m_patient_contactNo, m_patient_address, m_patient_gurdianName, m_patient_age);
		
		return output;
	}
	
	
	@GET
	@Path("/view")
	@Produces(MediaType.TEXT_HTML)
	public String readPatientDetails() {
		Patient patient = new Patient();
		
		return patient.readPatient();
	}
	

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String patientData) {

		// Convert the input string to a JSON object
		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject();

		// Read the values from the JSON object
		String m_patient_id = patientObject.get("m_patient_id").getAsString();
		String m_patient_userName = patientObject.get("m_patient_userName").getAsString();
		String m_patient_password = patientObject.get("m_patient_password").getAsString();
		String m_patient_name = patientObject.get("m_patient_name").getAsString();
		String m_patient_birthDate = patientObject.get("m_patient_birthDate").getAsString();
		Double m_patient_weight = patientObject.get("m_patient_weight").getAsDouble();
		String m_patient_bloodGroup = patientObject.get("m_patient_bloodGroup").getAsString();
		int m_patient_contactNo = patientObject.get("m_patient_contactNo").getAsInt();
		String m_patient_address = patientObject.get("m_patient_address").getAsString();
		String m_patient_gurdianName = patientObject.get("m_patient_gurdianName").getAsString();
		int m_patient_age = patientObject.get("m_patient_age").getAsInt();
		
		String output = PatientObj.updatePatient(m_patient_id,m_patient_userName,m_patient_password,m_patient_name, Date.valueOf(m_patient_birthDate), m_patient_weight, m_patient_bloodGroup, m_patient_contactNo, m_patient_address, m_patient_gurdianName, m_patient_age);

		return output;
	}


	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData) {
		Patient patient = new Patient();
		JsonObject PatientObj = new JsonParser().parse(patientData).getAsJsonObject();
		
		String m_patient_id = PatientObj.get("m_patient_id").getAsString();
		
		String output = patient.deletePatient(m_patient_id);
		return output;
	
	
	}
	

	
	
	
	}

