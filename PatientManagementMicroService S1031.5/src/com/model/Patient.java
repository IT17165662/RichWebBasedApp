package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {
	
	String userName;
	String password;
	String m_patient_id;
	String m_patient_userName;
	String m_patient_password ;
	String m_patient_name;
	Date m_patient_birthDate;
	double m_patient_weight;
	String m_patient_bloodGroup;
    int m_patient_contactNo;
    String m_patient_address;
    String m_patient_gurdianName;
    int m_patient_age;
	// A common method to connect to the DB
		private Connection connect() {

			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");

				// Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}

			return con;

		}
		
	
	
	public String PatientLogin(String UserName,String Password) {
		
		String output = "";
		
		try {
			
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for logging.";
		}
		
			String query = "SELECT m_patient_userName,m_patient_password FROM m_patient WHERE m_patient_userName = ?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setString(1, UserName);
			
			ResultSet rs = preparedStmt.executeQuery();
			
				while(rs.next()) {
					
					userName = rs.getString("m_patient_userName");
					password = rs.getString("m_patient_password");
				}
			
			con.close();
			
				if(userName.equalsIgnoreCase(UserName) && password.equalsIgnoreCase(Password)) {
					output = "success";
				}
		}catch(Exception e) {
			
			output="Failed";
			System.err.println(e.getMessage());
		}
		
		
		return output;
	}
	

	
	
public String insertPatient(String m_patient_id,String m_patient_userName,String m_patient_password,String m_patient_name,Date m_patient_birthDate,Double m_patient_weight,String m_patient_bloodGroup,int m_patient_contactNo,String m_patient_address,String m_patient_gurdianName,int m_patient_age ) {
		
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into m_patient(`m_patient_id`,`m_patient_userName`,`m_patient_password`,`m_patient_name`,`m_patient_birthDate`,`m_patient_weight`,`m_patient_bloodGroup`,`m_patient_contactNo`,`m_patient_address`,`m_patient_gurdianName`,`m_patient_age`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1,m_patient_id );
			preparedStmt.setString(2,m_patient_userName );
			preparedStmt.setString(3,m_patient_password );
			preparedStmt.setString(4, m_patient_name);
			preparedStmt.setDate(5, m_patient_birthDate);
			preparedStmt.setDouble(6, m_patient_weight);
			preparedStmt.setString(7, m_patient_bloodGroup);
			preparedStmt.setInt(8, m_patient_contactNo);
			preparedStmt.setString(9, m_patient_address);
			preparedStmt.setString(10, m_patient_gurdianName);
			preparedStmt.setInt(11, m_patient_age);

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Patient Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Patient.";
			System.err.println(e.getMessage());
		}

		return output;
	
	}
	

	

	public String readPatient() {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {

				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th></th><th>m_patient_id</th><th>m_patient_userName</th><th>m_patient_password</th><th>m_patient_name</th><th>m_patient_birthDate</th><th>m_patient_weight</th><th>m_patient_bloodGroup</th><th>m_patient_contactNo</th><th>m_patient_address</th><th>m_patient_gurdianName</th><th>m_patient_age</th><th>Update</th><th>Delete</th></tr>";

			String query = "select * from m_Patient";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String m_patient_id =rs.getString("m_patient_id");
				String m_patient_userName =rs.getString("m_patient_userName");
				String m_patient_password =rs.getString("m_patient_password");
				String m_patient_name = rs.getString("m_patient_name");
				Date m_patient_birthDate = rs.getDate("m_patient_birthDate");
				Double m_patient_weight = rs.getDouble("m_patient_weight");
				String m_patient_bloodGroup = rs.getString("m_patient_bloodGroup");
				int m_patient_contactNo = rs.getInt("m_patient_contactNo");
				String m_patient_address =rs.getString("m_patient_address");
				String m_patient_gurdianName =rs.getString("m_patient_gurdianName");
				int m_patient_age = rs.getInt("m_patient_age");
				
				// Add into the html table
				
				
				output += "<tr><td><input type='hidden'  id='hidPatientIDUpdate' name='hidPatientIDUpdate' value='"
						+ m_patient_id + "'></td>";
				output += "<td>" + m_patient_id + "</td>";
				output += "<td>" + m_patient_userName + "</td>";
				output += "<td>" + m_patient_password + "</td>";
				output += "<td>" + m_patient_name + "</td>";
				output += "<td>" + m_patient_birthDate + "</td>";
				output += "<td>" + m_patient_weight + "</td>";
				output += "<td>" + m_patient_bloodGroup + "</td>";
				output += "<td>" + m_patient_contactNo + "</td>";
				output += "<td>" + m_patient_address + "</td>";
				output += "<td>" + m_patient_gurdianName + "</td>";
				output += "<td>" + m_patient_age + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-t_payment_no='"+ m_patient_id + "'>" 
						 + "</td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Patient.";
			System.err.println(e.getMessage());
		}

		return output;

	}
	public String updatePatient(String m_patient_id,String m_patient_userName,String m_patient_password,String m_patient_name,Date m_patient_birthDate,Double m_patient_weight,String m_patient_bloodGroup,int m_patient_contactNo,String m_patient_address,String m_patient_gurdianName, int m_patient_age ) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {

				return "Error while connecting to the database for updating.";

			}

			// create a prepared statement
			String query = "UPDATE m_patient SET m_patient_userName=?,m_patient_password=?,m_patient_name=?,m_patient_birthDate=?,m_patient_weight=?,m_patient_bloodGroup=?,m_patient_contactNo=?,m_patient_address=?,m_patient_gurdianName=?,m_patient_age=?      WHERE m_patient_id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			
			preparedStmt.setString(1,m_patient_userName );
			preparedStmt.setString(2,m_patient_password );
			preparedStmt.setString(3, m_patient_name);
			preparedStmt.setDate(4, m_patient_birthDate);
			preparedStmt.setDouble(5, m_patient_weight);
			preparedStmt.setString(6, m_patient_bloodGroup);
			preparedStmt.setInt(7, m_patient_contactNo);
			preparedStmt.setString(8, m_patient_address);
			preparedStmt.setString(9, m_patient_gurdianName);
			preparedStmt.setInt(10, m_patient_age);
			preparedStmt.setString(11,m_patient_id );

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newPatient = readPatient();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":         \"Error while Updating the Patient.\"}";
			System.err.println(e.getMessage());
		}

		return output;

	}
	public String deletePatient(String m_patient_id) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {

				return "Error while connecting to the database for deleting.";

			}

			// create a prepared statement

			String query = "delete from m_patient where m_patient_id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, m_patient_id);

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newPatient = readPatient();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":         \"Error while Deleting the Patient.\"}";
			System.err.println(e.getMessage());
		}

		return output;

	}
}
