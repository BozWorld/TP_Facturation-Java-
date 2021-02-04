<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Factures</title>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>

<h1>Liste des Factures</h1>

<table>
 <c:forEach var="f" items="${listFactures}" >
    <tr>
	     <td><c:out value="${f.numero}"></c:out></td>
	     <td><c:out value="${f.date}"></c:out></td>
	     <td><c:out value="${f.client}"></c:out></td>
	     <td><c:out value="${f.prix}"></c:out></td>
	     
    </tr>
 </c:forEach>
 </table>


</div>

</body>
</html>