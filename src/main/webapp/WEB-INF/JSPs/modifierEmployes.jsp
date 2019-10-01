<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
    <title>Modification d'employés</title>
</head>

<body>


<h1>Modification d'employés</h1>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<form:form method="post" modelAttribute="modifFormEmploye" action="${contextPath}/admin/listeEmployes/updateemploye">
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Mot de passe</th>
            <th>Role</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${modifFormEmploye.modifEmployes}" var="employeModif" varStatus="status">
            <tr>
                <td>
                    <c:out value="${employeModif.id}"/>
                    <input type="hidden" name="modifEmployes[${status.index}].id" value="${employeModif.id}"/>
                </td>
                <td>
                    <c:out value="${employeModif.nom}"/>
                    <input type="text" name="modifEmployes[${status.index}].nom" value="${employeModif.nom}"/>
                </td>

                <td>
                    <c:out value="${employeModif.email}"/>
                    <input type="text" name="modifEmployes[${status.index}].email" value="${employeModif.email}"/>
                </td>
                <td>
                    <c:out value="${employeModif.password} "/>
                    <input type="text" name="modifEmployes[${status.index}].password" value="${employeModif.password}"/>
                </td>


                <td>
                    <form:select path="modifEmployes[${status.index}].idRole">

                        <c:forEach items="${roleListe}" var="role">

                            <c:if test="${role.idRole == employeModif.idRole}">

                                <form:option selected="selected" value="${role.idRole}" label="${role.nomRole}"/>
                            </c:if>
                            <c:if test="${role.idRole != employeModif.idRole}">
                                <form:option value="${role.idRole}" label="${role.nomRole}"/>
                            </c:if>
                        </c:forEach>
                    </form:select>
                </td>


            </tr>


        </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="Modifier"/>
</form:form>


</body>

</html>