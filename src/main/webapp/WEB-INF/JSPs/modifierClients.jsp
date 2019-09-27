<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<!-- @Author : NVV -->


<html>  

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<head>
	<title>Modifier les clients</title>
	<link
	    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	    rel="stylesheet">
</head>
  
<body>
<h1>Modifier Clients</h1>
	<form:form method="post" modelAttribute="modifFormClient" action="${contextPath}/admin/listeClients/updateclient">
	    <table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Prénom</th>
				<th scope="col">Nom</th>
				<th scope="col">N° Adresse</th>
				<th scope="col">Libellé adresse</th>
				<th scope="col">Complément adresse</th>
				<th scope="col">Code postal</th>
				<th scope="col">Ville</th>
				<th scope="col">Telephone</th>
				<th scope="col">Mail</th>
			</tr>
		</thead>
	        <tbody>
	            <c:forEach items="${modifFormClient.modifClients}" var="clientModif" varStatus="status">
	                <tr>
	                    <td>
	                    	<c:out value = "${clientModif.idClient}"/>
	                		<input type="hidden" name = "modifClients[${status.index}].idClient" value = "${clientModif.idClient}" />
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].prenom" value = "${clientModif.prenom}" />
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].nom"  value = "${clientModif.nom}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].numeroAdresse"  value = "${clientModif.numeroAdresse}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].libelle"  value = "${clientModif.libelle}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].complementAdresse"  value = "${clientModif.complementAdresse}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].codePostal"  value = "${clientModif.codePostal}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].ville"  value = "${clientModif.ville}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].tel"  value = "${clientModif.tel}"/>
	                    </td>
	                    <td>
	                		<input type="text" name = "modifClients[${status.index}].mail"  value = "${clientModif.mail}"/>
	                    </td>
	                </tr>
	                <!-- Value that should not be able to modify (and are useless to know) -->
	                <input type="hidden" name = "modifClients[${status.index}].idAdresse" value = "${clientModif.idAdresse}"/>
	                <input type="hidden" name = "modifClients[${status.index}].dateCreation"  value = "${clientModif.dateCreation}"/>
	                <input type="hidden" name = "modifClients[${status.index}].dateDerniereMiseAJour" value = "${clientModif.dateDerniereMiseAJour}"/>
	                	
	            </c:forEach>
	        </tbody>
	    </table>
	    <input type="submit" value="Modifier"/>
	</form:form>
	
    <input type="button" onclick="location.href='${contextPath}/accueil/admin'" value="Home" />

</body>
</html>