<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<!-- @Author : NVV -->


<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Client</title>
</head>
<body>

<h1>Ajouter Client</h1>
<form:form method="post" modelAttribute="creationForm" action="${contextPath}/admin/listeClients/ajouterClient">

   
    <label>Prénom : </label>
	<form:input path="prenom" />
    
    <label>Nom : </label>
	<form:input path="nom" /> <br/>
    
    <label>Email : </label>
	<form:input path="mail" />
     
    <label>Téléphone : </label>
	<form:input path="tel" /> <br/>
     
    <label>Numéro de rue : </label>
	<form:input path="numeroAdresse" />
     
    <label>Libellé : </label>
	<form:input path="libelle" /> <br/>
     
    <label>Complément adresse : </label>
	<form:input path="complementAdresse" /> <br/>
     
    <label>Code Postal : </label>
	<form:input path="codePostal" />
     
    <label>Ville : </label>
	<form:input path="ville" /> <br/>
    
        
    <input type="submit" value="Créer"/>
</form:form>


    <input type="button" onclick="location.href='${contextPath}/accueil/admin'" value="Home" />
    
</body>
</html>