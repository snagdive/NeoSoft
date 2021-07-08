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
	<h1>Welcome ${user.username}</h1>
	
	<form action="/project/add" method="POST">
	<table>
		<tr>
			<td> Project Name: <input type = "text" name = "projectName"/> </td>
			<td> Duration: <input type = "text" name = "duration"/> </td>
			<td> <input type="submit" value="Add" /> </td>			
		</tr>
	</table>	
	
	</form>
	
	<table>
		<tr> <th>Project Id</th> <th style="width: 40%">Project Name</th> <th>Duration</th> <th>Delete</th> </tr>
		<c:forEach var="project" items="${allProjects}">
			<tr>
				<td>${project.pid}</td>
				<td>${project.projectName}</td>
				<td>${project.duration}</td>
				<td><a href="/project/delete/${project.pid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	
	<a href="/student/edit/${user.uid}"> Add/Edit Personal Details </a>
	<br/><br/>
	<form action="/doLogout" method="POST">
    	<input type="submit" value="Logout" />
	</form>
	
</body>
</html>