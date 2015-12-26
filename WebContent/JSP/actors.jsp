<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="frmActorSearch" action="http://localhost:8080/AngularJSProject/UserProfileServlet">

<div>
<table  align="center">

<tr>
<td colspan="2"><b>Search Actors by :</b></td>
</tr>

<tr>
<td>First Name :</td>
<td><input type="text" name="fname" ></td>
</tr>

<tr>
<td>Last Name :</td>
<td><input type="text" name="lname" ></td>
</tr>

<tr>
<td colspan="2" align="right"><input type="submit" name="submit" value="Search"></td>
</tr>

</table>
</div>

<br></br>
<div>
<table style="width:100%" border="2">

<tr>
  <th>Last Name</th>
  <th>First Name</th>
  <th>Email</th>
</tr>


<c:forEach   items="${ customers }" var="customer" >
<tr>
<td align="center">
<c:out value="${customer.lName}" /> 
</td>
<td align="center">
<c:out value="${customer.fName}" /> 
</td>
<td align="center">
<c:out value="${customer.email}" /> 
</td>
</tr>
</c:forEach>

</table>
</div>

</form>

</body>
</html>