<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to Student API</title>
</head>
<body>
   <h1>Login</h1>
   <div >
   		<h2><font style="color: RED">${errorMsg}</font></h2>
   </div>
   <div>
   		<h2><font style="color: GREEN">${logoutMsg}</font></h2>
   </div>   
   <form name='f' action="/doLogin" method='POST'>
      <table>
         <tr>
            <td>Username:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
         	<td></td>
            <td> <input name="submit" type="submit" value="Login" /> </td>
         </tr>
      </table>    
  </form>

	<a href="/register" style="padding-left:5.5%">Register</a>

</body>
</html>