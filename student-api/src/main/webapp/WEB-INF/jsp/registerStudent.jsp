<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Student</title>
</head>
<body>
   <form name='registerStudent' action="/doRegister" method='POST' >
      <table>
         <tr>
            <td>Username:</td>
            <td><input type='text' name='username' placeholder='Username'></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='text' name='password' placeholder="New Password" /></td>
         </tr>
         <tr>
            <td>Role:</td>
            <td> 
            	<input type="radio" name='roles' value="ROLE_ADMIN" /> ADMIN
             	<input type="radio" name='roles' value="ROLE_USER" /> USER
            </td>
         </tr>
         <tr>
            <td>Active:</td>
            <td> <input type="radio" name='active' value=true /> YES
             	 <input type="radio" name='active' value=false /> NO 
	    </td>
         </tr>
         <tr>
            <th colspan="2"> <input name="submit" type="submit" value="Register" /> </th>
         </tr>
      </table>    
  </form>
</body>
</html>