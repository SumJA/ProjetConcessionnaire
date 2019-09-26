<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!doctype html>

<html lang="fr">
<head>
<meta charset="utf-8">
<title>Stock</title>
<meta name="description" content="Stock">
<meta name="author" content="SitePoint">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>

<body>
 <h1>Liste des stocks</h1>
    
    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Selection</th>
          <th>Nom Produit</th>
          <th>Prix Produit</th>
          <th>Quantité Produit Dispo</th>
          <th>Quantité Produit Réservé</th>
        </tr>
        <c:forEach items="${stocks}" var ="colonnestock">
        <tr>
          <td><input type="checkbox"></td>
          <td>${colonnestock.nomProduit}</td>
          <td>${colonnestock.prixProduit}</td>
          <td>${colonnestock.qteProduitDispo}</td>
          <td>${colonnestock.qteReserve}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
    
    <a class="btn btn-primary" href="${contextPath}/stock/ajouterProduit" role="button">Ajouter Produit</a>
    <a class="btn btn-primary" href="${contextPath}/stock" role="button">Supprimer ligne</a>
    <a class="btn btn-primary" href="${contextPath}/stock/modifierProduit" role="button">Modifier Produit</a>
    
</body>
</html>