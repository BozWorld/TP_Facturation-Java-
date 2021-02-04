<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Client !</title>
    <%@include file="commons/header.jsp" %>

</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>
<h1>Formulaire d'ajout d'un client</h1>

<form action="Client" method="post">
  <label for="Cnom">Nom</label>
  <input type="text" name="Cnom">
  <label for="Cadresse">Adresse</label>
  <input type="text" name="Cadresse">
  <input type="hidden" value="formCreate" name="actionPost"/>
  
  <input type="submit" value="Valider"/>
</form>
</div>

</body>
</html>