<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
	table {
	  border-collapse: collapse;
	  width: 50%;
	}
	
	th, td {
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even){background-color: #f2f2f2}
	
	th {
	  background-color: #04AA6D;
	  color: white;
	  width: 15%
	}
</style>

<title>Student Home Page</title>
</head>
<body>
	<h1>Welcome Admin ${user.username}</h1>
	
	<table>
		<tr> <th>Firstname</th> <th >Lastname</th> <th>Email</th> <th>Mobile</th> <th>Delete</th> </tr>
		<c:forEach var="student" items="${allStudents}">
			<tr>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
				<td>${student.mobile}</td>
				<td><a href="/student/delete/${student.sid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	<form action="/doLogout" method="POST">
    	<input type="submit" value="Logout" />
	</form>
	
</body>
</html>