<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione Profilo</title>
</head>
<body>
	<form action="newProfile" method="POST">
		<input type="email" id="email" name="email" /><br>
		<input type="password" id="psw" name="psw" /><br>
		
		<input type="radio" id="userType" name="userType" value="inserzionista">
		<label for="userType">Inserzionista</label><br>
		<input type="radio" id="userType" name="userType" value="professionista">
		<label for="female">Professionista</label><br>
		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>