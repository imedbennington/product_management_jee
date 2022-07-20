<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Ajouter un nouveau Produit</h1>
	<form method="post" action="addProduit">
			<div class="mb-3 mt-3">
				<label for="nom" class="form-label">Nom :</label> 
				<input type="text" class="form-control" id="nom" name="nom" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="prix" class="form-label">Prix :</label> 
				<input type="number" step="0.1" class="form-control" id="prix" name="prix" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="quantite" class="form-label">Quantité :</label> 
				<input type="number"  class="form-control" id="quantite" name="quantite" required>
			</div>
			<div class="mb-3 mt-3">
				<input type="submit"  class="btn btn-primary" value="Ajouter">
			</div>
		</form>

</div>

</body>

</body>
</html>