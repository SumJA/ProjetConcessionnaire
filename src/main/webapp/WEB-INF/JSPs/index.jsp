<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!doctype html>

<html lang="fr">
<head>
<meta charset="utf-8">

<title>The HTML5 Herald</title>
<meta name="description" content="The HTML5 Herald">
<meta name="author" content="SitePoint">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body>

	<button type="button" class="btn btn-primary btn-lg">Clients</button>
	<button type="button" class="btn btn-primary btn-lg">Employ�s</button>
	<button type="button" class="btn btn-primary btn-lg">Devis</button>
	<a href="${contextPath}/admin/test"> <button type="button" class="btn btn-primary btn-lg">Stocks</button></a>
	<button type="button" class="btn btn-primary btn-lg">Commandes</button>
	<a href="${contextPath}/logout"> <button type="button" class="btn btn-warning">Se d�connecter</button></a>

</body>
</html>