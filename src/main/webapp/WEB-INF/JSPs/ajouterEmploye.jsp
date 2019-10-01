<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

​


​ ​

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

​ ​ ​

<html>

<head>

    <meta charset="UTF-8">

    <title>Ajout d'employé</title>

</head>

<body>

<h1> Ajout d'employé</h1>

<form:form method="post" modelAttribute="creationForm"
           action="${contextPath}/admin/listeEmployes/ajouterEmploye">

    ​


    <label>Nom:</label>

    <form:input path="nom"/>
    <br/>


    <label>Email:</label>

    <form:input path="email"/>
    <br/>


    <label>Mot de passe: </label>

    <form:input path="password"/>
    <br/>


    <label>Role: </label>

    <%-- 		<form:input path="nomRole" /> --%>
    <!-- <br/> -->

    <!-- <input type="submit" value="ajouter Employé" /> -->

    <form:select path="idRole">
        <c:forEach items="${roleListe}" var="role">

            <form:option value="${role.idRole}" label="${role.nomRole}"/>
        </c:forEach>
    </form:select>


    <input type="submit" value="ajouter Employé"/>

</form:form>


</body>

</html>

