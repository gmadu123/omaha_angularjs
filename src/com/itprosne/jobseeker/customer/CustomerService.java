package com.itprosne.jobseeker.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itprosne.jobseeker.customer.pojos.Customer;
import com.itprosne.jobseeker.db.DatabaseManager;

public class CustomerService {
	
	
	public Customer getCustomerProfile(Integer customerId){
		Customer c1 = null;
		try {
			DatabaseManager dm = new DatabaseManager();
			Connection myDBConnection =  dm.getConnection("sakila", "root", "Bangaram1");
			
			 
			  Statement  statement = myDBConnection.createStatement();
			  ResultSet resultSet = statement.executeQuery("select * from sakila.customer  where customer_id="+customerId);
			  
			  while (!resultSet.isLast()) {
				  
				  resultSet.next();
				  String fName = resultSet.getString("first_name");
				  String lName = resultSet.getString("last_name");
				  String email = resultSet.getString("email");
				  
				  c1 = new Customer();// information for tamil guy
					 c1.setfName(fName);
					 c1.setlName(lName);
					 c1.setEmail(email);
					
				  
			  }

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c1;
	}
	
	
	
	public List<Customer> getCustomerProfileByFirstName(String fstName, String lstName){
		Customer c1 = null;
		List<Customer> customersFound = new ArrayList<>();
		
		try {
			DatabaseManager dm = new DatabaseManager();
			Connection myDBConnection =  dm.getConnection("sakila", "root", "Bangaram1");
			
			 
			  Statement  statement = myDBConnection.createStatement();
			  ResultSet resultSet = statement.executeQuery("select * from sakila.customer  where first_name='"+fstName+"' and last_name='"+lstName+"'");
			  
			  while (!resultSet.isLast()) {
				  
				  resultSet.next();
				  String fName = resultSet.getString("first_name");
				  String lName = resultSet.getString("last_name");
				  String email = resultSet.getString("email");
				  
				  c1 = new Customer();// information for tamil guy
					 c1.setfName(fName);
					 c1.setlName(lName);
					 c1.setEmail(email);
					
					 customersFound.add(c1);
				  
			  }

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customersFound;
	}

}
