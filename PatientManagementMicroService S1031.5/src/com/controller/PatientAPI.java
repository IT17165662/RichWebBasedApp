package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Patient;

/**
 * Servlet implementation class PatientAPI
 */
@WebServlet("/PatientAPI")
public class PatientAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Patient patientobj = new Patient();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output = patientobj.insertPatient(request.getParameter("m_patient_id"),      
				request.getParameter("m_patient_userName"),        
				request.getParameter("m_patient_password"),
		        request.getParameter("m_patient_name"),    
		        Date.valueOf(request.getParameter("m_patient_birthDate")),        
		        Double.valueOf(request.getParameter("m_patient_weight")),
		        request.getParameter("m_patient_bloodGroup"),    
		        Integer.parseInt(request.getParameter("m_patient_contactNo")),        
		        request.getParameter("m_patient_address"),
		        request.getParameter("m_patient_gurdianName"),    
		        Integer.parseInt(request.getParameter("m_patient_age"))
		        );
			
		 response.getWriter().write(output); 
		//doGet(request, response);
	}
	
	private static Map getParasMap(HttpServletRequest request) {  
		Map<String, String> map = new HashMap<String, String>();  
		try  {   Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");   
		String queryString = scanner.hasNext() ?          
				scanner.useDelimiter("\\A").next() : "";   
				scanner.close(); 
		
	
	 
	  String[] params = queryString.split("&");   
	  for (String param : params)   
	  { 
		  String[] p = param.split("=");    
		  map.put(p[0], p[1]);  
		  } 
	  }  catch (Exception e)  {
		  
	  } return map;
	  } 
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException
	{ 
		Map paras = getParasMap(request); 
	 
	 String output = patientobj.updatePatient(     
			 paras.get("m_patient_id").toString(),     
			 paras.get("m_patient_userName").toString(),        
			 paras.get("m_patient_password").toString(),        
			 paras.get("m_patient_name").toString(),
			 Date.valueOf(paras.get("m_patient_birthDate").toString()),     
			 Double.parseDouble(paras.get("m_patient_weight").toString()),      
			 paras.get("m_patient_bloodGroup").toString(),  
			 Integer.parseInt(paras.get("m_patient_contactNo").toString()),     
			 paras.get("m_patient_address").toString(),        
			 paras.get("m_patient_gurdianName").toString(),  
			 Integer.parseInt(paras.get("m_patient_age").toString()));   
		
	 
	 response.getWriter().write(output);
	 } 
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException
	{  
		Map paras = getParasMap(request); 
	 
	 String output = patientobj.deletePatient(paras.get("t_payment_no").toString()); 
	 
	 response.getWriter().write(output); } 
}
