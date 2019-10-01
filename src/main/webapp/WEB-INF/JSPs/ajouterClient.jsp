<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter Client</title>

</head>
<body>

<h1>Ajouter Client</h1>
<form:form method="post" modelAttribute="creationForm" action="${contextPath}/admin/listeClients/ajouterClient">

    <label>Prénom : </label>
    <form:input path="prenom"/>
    <b><form:errors path="prenom"/></b>

    <label>Nom : </label>
    <form:input path="nom"/>
    <b><form:errors path="nom"/></b> <br/>

    <label>Email : </label>
    <form:input path="mail"/>
    <b><form:errors path="mail"/></b>

    <label>Téléphone : </label>
    <form:input path="tel"/>
    <b><form:errors path="tel"/></b> <br/>

    <label>Numéro de rue : </label>
    <form:input path="numeroAdresse"/>
    <b><form:errors path="numeroAdresse"/></b>

    <label>Libellé : </label>
    <form:input path="libelle"/>
    <b><form:errors path="libelle"/></b><br/>

    <label>Complément adresse : </label>
    <form:input path="complementAdresse"/>
    <b><form:errors path="complementAdresse"/></b><br/>

    <label>Code Postal : </label>
    <form:input path="codePostal"/>
    <b><form:errors path="codePostal"/></b>

    <label>Ville : </label>
    <form:input path="ville"/>
    <b><form:errors path="ville"/></b> <br/>

    <label>Pays : </label>
    <form:input path="pays"/>
    <b><form:errors path="pays"/></b> <br/>

    <input type="submit" value="Créer"/>
</form:form>


<input type="button" onclick="location.href='${contextPath}/admin/listeClients'" value="Retour"/>

</body>
</html>