<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<!-- @Author : NVV -->


<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<form:form method="post" modelAttribute="modifFormClient" action="${contextPath}/admin/listeClients/updateclient">
    <table border="1">
    <thead>
        <tr>
            <th> </th>
            <th>ID</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Libellé adresse</th>
            <th>Code postal</th>
            <th>Ville</th>
            <th>Téléphone</th>
            <th>Mail</th>
            <th>Date de création</th>
        </tr>
    </thead>
        <tbody>
            <c:forEach items="${modifFormClient.modifClients}" var="clientModif" varStatus="status">
                <tr>
                	<td>
                		<input type="checkbox" name = "modifClients[${status.index}].checked" />
                	</td>
                    <td>
                        <c:out value="${clientModif.idClient}"/>
                		<input type="hidden" name = "modifClients[${status.index}].idClient" value = "${clientModif.idClient}" />
                    </td>
                    <td>
                        <c:out value="${clientModif.prenom}"/>
                		<input type="hidden" name = "modifClients[${status.index}].prenom" value = "${clientModif.prenom}" />
                    </td>
                    <td>
                        <c:out value="${clientModif.nom}"/>
                		<input type="hidden" name = "modifClients[${status.index}].nom"  value = "${clientModif.nom}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.libelle}"/>
                		<input type="hidden" name = "modifClients[${status.index}].libelle"  value = "${clientModif.libelle}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.codePostal}"/>
                		<input type="hidden" name = "modifClients[${status.index}].codePostal"  value = "${clientModif.codePostal}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.ville}"/>
                		<input type="hidden" name = "modifClients[${status.index}].ville"  value = "${clientModif.ville}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.tel}"/>
                		<input type="hidden" name = "modifClients[${status.index}].tel"  value = "${clientModif.tel}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.mail}"/>
                		<input type="hidden" name = "modifClients[${status.index}].mail"  value = "${clientModif.mail}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.dateCreation}"/>
                		<input type="hidden" name = "modifClients[${status.index}].dateCreation"  value = "${clientModif.dateCreation}"/>
                    </td>
                </tr>
                
                <input type="hidden" name = "modifClients[${status.index}].idAdresse" value = "${clientModif.idAdresse}"/>
                	
            </c:forEach>
        </tbody>
    </table>
    <input type="submit"/>
</form:form>