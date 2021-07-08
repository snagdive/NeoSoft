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
   <form:form name='editPersonalDetails' action="/student/update" method='POST' modelAttribute="student">
      <table>
         <tr>
            <td>Firstname:</td>
            <td><form:input type='text' path='firstname' name='firstname'/></td>
         </tr>
         <tr>
            <td>Lastname:</td>
            <td><form:input type='text' path='lastname' name='lastname'/></td>
         </tr>
         <tr>
            <td>Mobile:</td>
            <td><form:input type='text' path='mobile' name='mobile'/></td>
         </tr>
         <tr>
            <td>Email:</td>
            <td><form:input type='text' path='email' name='email'/></td>
         </tr>
         <tr>
            <th colspan="2"> <input name="submit" type="submit" value="Add/Update" /> </th>
         </tr>
      </table>    
  </form:form>
</body>
</html>