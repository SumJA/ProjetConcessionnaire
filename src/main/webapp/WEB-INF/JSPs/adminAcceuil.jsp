<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Admin's Dashboard">

    <title>Admin - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin.css" rel="stylesheet">

</head>

<body>
<a href="${contextPath}/admin/listeClients">
    <button type="button" class="btn btn-primary btn-lg">Clients</button>
</a>
<a href="${contextPath}/admin/listeEmployes">
    <button type="button" class="btn btn-primary btn-lg">Employés</button>
</a>
<button type="button" class="btn btn-primary btn-lg">Devis</button>
<a href="${contextPath}/admin/test">
    <button type="button" class="btn btn-primary btn-lg">Stocks</button>
</a>
<button type="button" class="btn btn-primary btn-lg">Commandes</button>
<sec:authorize access="isAuthenticated()">
    <a href="${contextPath}/logout">
        <button type="button" class="btn btn-warning">Se déconnecter</button>
    </a>
</sec:authorize>
</body>
</html>