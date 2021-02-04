<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle article !</title>
    <%@include file="commons/header.jsp" %>

</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>
<h1>Formulaire d'ajout d'article</h1>

<form action="Article" method="post">
  <label for="Anom">Nom</label>
  <input type="text" name="Anom">
  <label for="Aprix">Prix</label>
  <input type="text" name="Aprix">
  <input type="hidden" value="formCreate" name="actionPost"/>
  
  <input type="submit" value="Valider"/>
</form>
</div>

</body>
</html>