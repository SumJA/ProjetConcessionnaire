<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
l

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Register page">

    <title>Register</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Créer un compte</div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="inscription"
                       class="form-signin">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <spring:bind path="nom">
                                    <form:input type="text" path="nom" class="form-control"
                                                placeholder="Nom" required="required" autofocus="true"/>
                                    <form:errors path="nom" cssStyle="color: red"/>
                                    <form:label path="nom">Nom</form:label>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <spring:bind path="prenom">
                                    <form:input type="text" path="prenom" class="form-control"
                                                placeholder="Prenom" required="required" autofocus="true"/>
                                    <form:errors path="prenom" cssStyle="color: red"/>
                                    <form:label path="prenom">Prénom</form:label>
                                </spring:bind>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <spring:bind path="username">
                            <form:input type="text" path="username" class="form-control"
                                        placeholder="Username" required="required" autofocus="true"/>
                            <form:errors path="username" cssStyle="color: red/"/>
                            <form:label path="username">Nom d'Utilisateur</form:label>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <spring:bind path="email">
                            <form:input type="email" path="email" class="form-control"
                                        placeholder="Email" autofocus="true" required="required"/>
                            <form:errors path="email" cssStyle="color: red"/>
                            <form:label path="email">Adresse email</form:label>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <spring:bind path="password">
                            <form:input type="password" path="password" class="form-control"
                                        placeholder="Mot de Passe" autofocus="true" required="required"/>
                            <form:errors path="password" cssStyle="color: red"/>
                            <form:label path="password">Mot de Passe</form:label>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <spring:bind path="passwordConfirm">
                            <form:input type="password" path="passwordConfirm" class="form-control"
                                        placeholder="Confirmer le Mot de Passe" autofocus="true" required="required"/>
                            <form:errors path="passwordConfirm" cssStyle="color: red"/>
                            <form:label path="passwordConfirm">Confirmer le Mot de Passe</form:label>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <spring:bind path="role">
                            <form:select path="role" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                <option selected>Selectionner un rôle</option>
                                <c:forEach items="${role}" var="liste" begin="0" end="${role.size()}">
                                    <form:option value="${liste.getId()}">${liste.getNom()}</form:option>
                                </c:forEach>
                            </form:select>
                            <form:errors path="role"/>
                        </spring:bind>
                    </div>
                </div>
                <button class="btn btn-primary btn-block" type="submit">S'inscrire</button>
            </form:form>
            <div class="text-center">
                <a class="d-block small mt-3" href="/login">Déjà membre ?</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>