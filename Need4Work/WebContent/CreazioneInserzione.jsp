<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione inserzione</title>
</head>
<body>
<h1>Crea la tua inserzione</h1>
<form method="POST" action="CreateJob">
	<table>
		<tr><td>Titolo</td><td><input type="text" name="titolo" required></td></tr>
		<tr><td>Descrizione</td><td><input type="text" name="descrizione" required></td></tr>
		<tr><td>Importo massimo</td><td><input type="text" name="importoMax" required></td></tr>
		<tr><td>Data fine asta</td><td><input type="date" name="dataFine" required></td></tr>
		<tr><td></td><td><input type="submit" value="Pubblica inserzione"></td></tr>
	</table>
</form>
</body>
</html>