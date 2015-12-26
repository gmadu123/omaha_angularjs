package com.itprosne.jobseeker.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	

	  private Connection connection = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	
	
	public Connection getConnection(String schemaName, String userName,String password){
		
		try {
			// database driver class
			 Class.forName("com.mysql.jdbc.Driver");
			 String url = "jdbc:mysql://localhost/"+schemaName;
			 connection = DriverManager.getConnection (url, userName, password);
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return connection;
	}
	
	public void closeConnection(Connection conn){
		try {
			if(  ! conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	  
	  

	  public void readDataBase() throws Exception {
	    try {
	    	
	    	//test
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB gopi
	      
	      String url = "jdbc:mysql://localhost/sakila";
	      connection = DriverManager.getConnection (url, "root", "Bangaram1");
	      
	     

	      // Statements allow to issue SQL queries to the database
	      statement = connection.createStatement();
	      // Result set get the result of the SQL query
	      resultSet = statement
	          .executeQuery("select * from sakila.customer");
	      writeResultSet(resultSet);

	    /*  // PreparedStatements can use variables and are more efficient
	      preparedStatement = connect
	          .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
	      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
	      // Parameters start with 1
	      preparedStatement.setString(1, "Test");
	      preparedStatement.setString(2, "TestEmail");
	      preparedStatement.setString(3, "TestWebpage");
	      preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
	      preparedStatement.setString(5, "TestSummary");
	      preparedStatement.setString(6, "TestComment");
	      preparedStatement.executeUpdate();

	      preparedStatement = connect
	          .prepareStatement("SELECT myuser, webpage, datum, summery, COMMENTS from feedback.comments");
	      resultSet = preparedStatement.executeQuery();
	      writeResultSet(resultSet);

	      // Remove again the insert comment
	      preparedStatement = connect
	      .prepareStatement("delete from feedback.comments where myuser= ? ; ");
	      preparedStatement.setString(1, "Test");
	      preparedStatement.executeUpdate();
	      
	      resultSet = statement
	      .executeQuery("select * from feedback.customer");
	      writeMetaData(resultSet);*/
	      
	      
	      System.out.println("11111111111111111");
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }

	  private void writeMetaData(ResultSet resultSet) throws SQLException {
	    //   Now get some metadata from the database
	    // Result set get the result of the SQL query
	    
	    System.out.println("The columns in the table are: ");
	    
	    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
	    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
	      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
	    }
	  }

	  private void writeResultSet(ResultSet resultSet) throws SQLException {
	    // ResultSet is initially before the first data set
	    while (!resultSet.isLast()) {
	    	resultSet.next();
	      String fName = resultSet.getString("first_name");
	      String lName = resultSet.getString("last_name");
	      String email = resultSet.getString("email");
	      System.out.println(fName + " - "+lName + " - "+email);
	      System.out.println("email: " + email);
	      
	    }
	  }

	  // You need to close the resultSet
	  private void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connection != null) {
	        connection.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	  
	  public static void main(String[] args) throws Exception {
		  DatabaseManager dao = new DatabaseManager();
		    dao.readDataBase();
		  }
}







