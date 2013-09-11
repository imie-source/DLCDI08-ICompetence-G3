<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel=stylesheet type=text/css href=css/style.css />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Projets</title>
</head>
<body>
	<jsp:include page="HeaderTest.jsp" />
	<div class="contenu">
		<div class="titre">
			<h1>Liste des Projets</h1>
		</div>
		<div class="liste">
			<div class="global">
				<div class="tableauContainer">
					<div class="tableau">

						<div class="ligneTableauLine ligneTableauHeader">
							<div id=Nom
								class="celluleTableauInTable celluleTableau celluleTableau200">Intitulé</div>
							<div
								class="celluleTableauInTable celluleTableau celluleTableau100">Chef
								de projet</div>
							<div
								class="celluleTableauInTable celluleTableau celluleTableau100">Statut</div>
							<%-- <div class="celluleTableauInTable celluleTableau celluleTableau100">Action</div> --%>
						</div>

						<%
							int ligne = 0;
						%>
						<c:forEach var="projetDTO" items="${listeProjet}"
							varStatus="numLigne">

							<%
								Boolean isAlternativLigne = ligne % 2 > 0;
									String ligneAlternative = isAlternativLigne ? "ligneTableauAlternativLine"
											: "ligneTableauNormalLine";
									ligne++;
							%>
							<div class="ligneTableauLine <%=ligneAlternative%>">
								<div
									class="celluleTableauInTable celluleTableau celluleTableau200">
									<a href="./Projet?numligne=${numLigne.index}"> <c:out
											value="${projetDTO.intitule}" />
									</a>
								</div>
								<div
									class="celluleTableauInTable celluleTableau celluleTableau100">
									<c:out value="${projetDTO.chefDeProjet.nom}" />
								</div>
								<div
									class="celluleTableauInTable celluleTableau celluleTableau100">
									<c:out value="${projetDTO.statutProjet.valeurStatut}" />
								</div>
								<%--Boutons AFFICHER MODIFIER SUPPRIMER
<div class="celluleTableauInTable celluleTableau celluleTableau100">
<form action="./Projet">
<input type="hidden" name="ligneProjet" value="${numLigne.index}"></input>
<input type="submit" name="read" value="afficher"></input>
</form>

<form action="./Projet">
<input type="hidden" name="numProjet" value=<c:out value="${projetDTO.num}"/>> </input>
<input type="submit" name="update" value="modifier"></input>
</form>

<form id="sup" action="./Projet">
<input type="hidden" name="ligneProjet" value="${numLigne.index}"></input>
<input type="hidden" id="intituleProjet" value="${projetDTO.intitule}"></input>
<input type="submit" name="delete" value="supprimer"></input>
</form>	
</div>
--%>

							</div>

						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>