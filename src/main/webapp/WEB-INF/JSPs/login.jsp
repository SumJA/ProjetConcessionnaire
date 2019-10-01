<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="login page">
    <title>Login</title>
    <!-- Custom fonts -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <link href="css/sb-admin.min.css" rel="stylesheet">
</head>

<body class="bg-dark">

<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Se Connecter</div>
        <div class="card-body">
            <form:form method="POST" action="${contextPath}/login" class="form-signin" modelAttribute="login">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="username" class="form-control" placeholder="Nom d'utilisateur"
                                    required="required" autofocus="autofocus" autocomplete="username" path="username"/>
                        <form:label path="username">Nom d'utilisateur</form:label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="password" id="password" class="form-control" placeholder="Mot de Passe"
                                    required="required" autocomplete="current-password" path="password"/>
                        <form:label path="password">Mot de Passe</form:label>
                    </div>
                </div>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <div class="checkbox">
                        <span style="color: green">${message}</span>
                        <span style="color: red">${error}</span>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-primary btn-block" type="submit">Se Connecter</button>
            </form:form>
            <div class="text-center">
                <a class="d-block small mt-3" href="${contextPath}/inscription">Pas de compte ?</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.js" type="text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.js" type="text/javascript"></script>

</body>
</html>