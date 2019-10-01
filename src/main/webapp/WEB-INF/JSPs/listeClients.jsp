<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body>
<h1>Afficher Clients</h1>

<%--@elvariable id="modifFormClient" type="ModifFormClient"--%>
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
            <th scope="col">Pays</th>
            <th scope="col">Telephone</th>
            <th scope="col">Mail</th>
            <th scope="col">Date création</th>
            <th scope="col">Date dernière MAJ</th>
        </tr>
        </thead>
        <sp>
            <tbody>
            <c:forEach items="${modifFormClient.modifClients}" var="clientModif" varStatus="status">
                <tr>
                    <td>
                        <input type="checkbox" name="modifClients[${status.index}].checked"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.idClient}"/>
                        <input type="hidden" name="modifClients[${status.index}].idClient"
                               value="${clientModif.idClient}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.prenom}"/>
                        <input type="hidden" name="modifClients[${status.index}].prenom" value="${clientModif.prenom}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.nom}"/>
                        <input type="hidden" name="modifClients[${status.index}].nom" value="${clientModif.nom}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.numeroAdresse}"/>
                        <input type="hidden" name="modifClients[${status.index}].numeroAdresse"
                               value="${clientModif.numeroAdresse}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.libelle}"/>
                        <input type="hidden" name="modifClients[${status.index}].libelle"
                               value="${clientModif.libelle}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.complementAdresse}"/>
                        <input type="hidden" name="modifClients[${status.index}].complementAdresse"
                               value="${clientModif.complementAdresse}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.codePostal}"/>
                        <input type="hidden" name="modifClients[${status.index}].codePostal"
                               value="${clientModif.codePostal}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.ville}"/>
                        <input type="hidden" name="modifClients[${status.index}].ville" value="${clientModif.ville}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.pays}"/>
                        <input type="hidden" name="modifClients[${status.index}].pays" value="${clientModif.pays}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.tel}"/>
                        <input type="hidden" name="modifClients[${status.index}].tel" value="${clientModif.tel}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.mail}"/>
                        <input type="hidden" name="modifClients[${status.index}].mail" value="${clientModif.mail}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.dateCreation}"/>
                        <input type="hidden" name="modifClients[${status.index}].dateCreation"
                               value="${clientModif.dateCreation}"/>
                    </td>
                    <td>
                        <c:out value="${clientModif.dateDerniereMiseAJour}"/>
                        <input type="hidden" name="modifClients[${status.index}].dateDerniereMiseAJour"
                               value="${clientModif.dateDerniereMiseAJour}"/>
                    </td>
                </tr>

                <input type="hidden" name="modifClients[${status.index}].idAdresse" value="${clientModif.idAdresse}"/>
            </c:forEach>
            </tbody>
        </sp>
    </table>
    <input type="submit" value="Modifier sélection"/>
</form:form>

<a href="${contextPath}/admin/listeClients/ajouterClient">
    <button type="submit">Ajouter un client</button>
</a>

<input type="button" onclick="location.href='${contextPath}/home'" value="Home"/>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>
<script src="js/demo/chart-area-demo.js"></script>
</body>

</html>