<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajouter Produit</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<div class="container">
		<form:form method="POST" modelAttribute="ajouterProduit"
			class="form-signin">
			<h2 class="form-signin-heading">Ajouter un produit</h2>

			<spring:bind path="nomProduit">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="nomProduit" class="form-control"
						placeholder="Nom du produit" autofocus="true"></form:input>
				</div>
			</spring:bind>

			<spring:bind path="prixProduit">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="prixProduit" class="form-control"
						placeholder="Prix du produit" autofocus="true"></form:input>
				</div>
			</spring:bind>

			<spring:bind path="qteProduitDispo">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="qteProduitDispo" class="form-control"
						placeholder="Quantité de produit disponible" autofocus="true"></form:input>
				</div>
			</spring:bind>

			<spring:bind path="qteReserve">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="qteReserve" class="form-control"
						placeholder="Quantité de produit reservé" autofocus="true"></form:input>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter le produit</button>
		</form:form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>