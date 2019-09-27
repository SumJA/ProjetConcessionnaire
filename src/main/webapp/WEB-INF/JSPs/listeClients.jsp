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
<title>Afficher les clients</title>

<link
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    rel="stylesheet">
    
</head>
  
<body>
<h1>Afficher Clients</h1>
	
	<form:form method="post" modelAttribute="modifFormClient" action="${contextPath}/admin/listeClients/gotoupdateclient">
	    <table class="table table-striped">
		<thead>
			<tr>
				<th scope="col"></th>
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
				<th scope="col">Date création</th>
				<th scope="col">Date dernière MAJ</th>
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
	                    <c:out value="${clientModif.numeroAdresse}"/>
	            		<input type="hidden" name = "modifClients[${status.index}].numeroAdresse"  value = "${clientModif.numeroAdresse}"/>
	                </td>
	                <td>
	                    <c:out value="${clientModif.libelle}"/>
	            		<input type="hidden" name = "modifClients[${status.index}].libelle"  value = "${clientModif.libelle}"/>
	                </td>
	                <td>
	                    <c:out value="${clientModif.complementAdresse}"/>
	            		<input type="hidden" name = "modifClients[${status.index}].complementAdresse"  value = "${clientModif.complementAdresse}"/>
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
	                <td>
	                    <c:out value="${clientModif.dateDerniereMiseAJour}"/>
	            		<input type="hidden" name = "modifClients[${status.index}].dateDerniereMiseAJour"  value = "${clientModif.dateDerniereMiseAJour}"/>
	                </td>
	            </tr>
	            
	            <input type="hidden" name = "modifClients[${status.index}].idAdresse" value = "${clientModif.idAdresse}"/>
	            	
	        </c:forEach>
		</tbody>
	</table>

	    <input type="submit" value = "Modifier sélection"/>
	</form:form>

	<form method="get" action="${contextPath}/admin/listeClients/ajouterClient">
	    <button type="submit">Ajouter un client</button>
	</form>
	
	    <input type="button" onclick="location.href='${contextPath}/accueil/admin'" value="Home" />
</body>    
	</html>    