<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Projets</title>
<link rel="stylesheet" href="JQuery/jquery-ui.css"></link>
<script type="text/javascript" src=JQuery/jquery-1.9.1.js></script>
<script type="text/javascript" src=JQuery/ui-1.10.3-jquery-ui.js></script>
<script>
$(document).ready(function(){
	$('.ligneTableauAlternativLine').mouseover(function(){
		$(this).css("background-color", "#fdb515");
		$(this).css("color", "white");})
		.mouseleave(function(){
			$(this).css("background-color", "#e2e2e2");
			$(this).css("color", "black");});
	$('.ligneTableauNormalLine').mouseover(function(){
		$(this).css("background-color", "#fdb515");
		$(this).css("color", "white");})
			.mouseleave(function(){
		$(this).css("background-color", "white");
		$(this).css("color", "black");});

	});
</script>
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
						<a href="./Projet?numligne=${numLigne.index}"class = "lienListe">
							<div class="ligneTableauLine <%=ligneAlternative%>">
								<div class="ligneTableauLine <%=ligneAlternative%>">
									<div
										class="celluleTableauInTable celluleTableau celluleTableau200">
										 <c:out value="${projetDTO.intitule}" />
									</div>
									<div
										class="celluleTableauInTable celluleTableau celluleTableau100">
										<c:out value="${projetDTO.chefDeProjet.nom}" />
										<c:out value="${projetDTO.chefDeProjet.prenom}" />
									</div>
									<div
										class="celluleTableauInTable celluleTableau celluleTableau100">
										<c:out value="${projetDTO.statutProjet.valeurStatut}" />
									</div>
						</a>
					
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
				<form action="./Projet">
					<input type="submit" name="create" id="create" value="creer"></input>
				</form>
				</div>
				</div>
				</div>
				
				
				
				
				
</body>
</html>