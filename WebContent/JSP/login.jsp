<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.itprosne.jobseeker.customer.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
UserDTO user = (UserDTO)request.getAttribute("userInfo"); 
%>

<p>Thank you for registering. Your details have been saved as below:</p>
	<table align="center">
		<tr>
		    <th>Field</th>
		    <th>Values</th>
		</tr>
		<tr>
			<td><label>User Name</label></td>
			<td><%= user.getFirstName() %></td>
		</tr>
		<tr>
			<td><label>User Name</label></td>
			<td><%= user.getLastName() %></td>
		</tr>
		<tr>
			<td><label>User Name</label></td>
			<td><%= user.getUserName() %></td>
		</tr>
		<tr>
			<td><label>Date of Birth</label></td>
			<td><%= user.getDateOfBirth() %></td>
		</tr>
		<tr>
			<td><label>Email</label></td>
			<td><%= user.getEmail() %></td>
		</tr>
		<tr>
			<td><label>Telephone</label></td>
			<td><%= user.getTelephone() %></td>
		</tr>
		<tr>
			<td><label>Address</label></td>
			<td><%= user.getAddress() %></td>
		</tr>
		<tr>
			<td><label>ZipCode</label></td>
			<td><%= user.getZip() %></td>
		</tr>
	</table>


</body>
</html>