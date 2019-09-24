<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>inscription</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<div class="container">
		<form:form method="POST" modelAttribute="inscription" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="nom">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="nom" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="nom"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="email" class="form-control"
						placeholder="Email" autofocus="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password" autofocus="true"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm" class="form-control"
						placeholder="Confirmer Password" autofocus="true"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="role">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
						<option selected>Selectionner un rôle</option>
						<option value="admin">Administrateur</option>
						<option value="magasinier">Magasinier</option>
						<option value="commercial">Commercial</option>
					</select>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>