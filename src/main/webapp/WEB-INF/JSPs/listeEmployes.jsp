<%@ page language="java" contentType="text/html; charset=utf-8"
         isELIgnored="false" pageEncoding="utf-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>

    <title>Liste des employés</title>

</head>

<body>


<h1>Liste des employés</h1>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

​ ​

<form:form method="post" modelAttribute="modifFormEmploye"
           action="${contextPath}/admin/listeEmployes/gotoupdateemploye">

    <table border="1">

        <thead>

        <tr>
            <th>Choix</th>
            <th>Id</th>
            <th>Nom</th>

            <th>Email</th>


            <th>Role</th>


        </tr>

        </thead>

        <tbody>

        <c:forEach items="${modifFormEmploye.modifEmployes}" var="employeModif" varStatus="status">

            <tr>

                <td>
                    <input type="checkbox" name="modifEmployes[${status.index}].checked"/>
                </td>
                <td>
                    <c:out value="${employeModif.id }"/>
                    <input type="hidden" name="modifEmployes[${status.index}].id" value="${employeModif.id }"/>
                </td>

                <td>
                    <c:out value="${employeModif.nom}"/>
                    <input type="hidden" name="modifEmployes[${status.index}].nom" value="${employeModif.nom}"/>
                </td>

                <td>
                    <c:out value="${employeModif.email}"/>
                    <input type="hidden" name="modifEmployes[${status.index}].email" value="${employeModif.email}"/>
                </td>

                <td>
                    <c:out value="${employeModif.nomRole}"/>
                    <input type="hidden" name="modifEmployes[${status.index}].nomRole" value="${employeModif.nomRole}"/>
                </td>


            </tr>


            <input type="hidden" name="modifEmployes[${status.index}].idRole" value="${employeModif.idRole}"/>

        </c:forEach>

        </tbody>

    </table>
    <input type="submit" value="Modifier "/>
    <input type="button" onclick="location.href='${contextPath}/admin/ajouterEmploye'" value="Ajouter"/>
    <input type="button" onclick="location.href='${contextPath}/home'" value="Revenir à la page d'accueil"/>


    <br/>

</form:form>
</body>


</html>
