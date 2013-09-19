<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.imie.formation.DTO.UtilisateurDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel=stylesheet type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel="stylesheet" href="JQuery/jquery-ui.css"></link>
<script type="text/javascript" src=JQuery/jquery-1.9.1.js></script>
<script type="text/javascript" src=JQuery/ui-1.10.3-jquery-ui.js></script>
<title>Liste des Utilisateurs</title>
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
	<!--
 Bouton de confirmation

	<script>
		jQuery(document).ready(function() {
			// Du code en jQuery va pouvoir être tapé ici !

			 $('#jq-dialog').dialog({
                 autoOpen: false,
                 width: 400,
                 modal: true,
                 resizable: false,
                 buttons: {
                     "Oui": function() {
                    	 submit();   
                     },
                     "Non": function() {
                         $(this).dialog("close");
                     }
                 }
             });
             
             $('form#sup').submit(function(e){
             	e.preventDefault();
             	var nomUtilisateur = $(this).children('input#nomUtilisateur').val();
             	var prenomUtilisateur = $(this).children('input#prenomUtilisateur').val();
             	 $("span#dialog-nomUtilisateur strong").html(nomUtilisateur+" "+prenomUtilisateur);
             	 
                 $('#jq-dialog').dialog('open');
             });


			
		});
	</script>


<div id="jq-dialog">
	<p class="alert alert-error">Voulez-vous supprimer :
    <span id="dialog-nomUtilisateur"><strong></strong></span></p>
</div>
-->
	<div class="contenu">
		<div class="titre">
			<h1>Liste des utilisateurs</h1>
		</div>
		<div class="liste">
			<div class="global">
				<div class="tableauContainer">
					<div class="tableau">

						<div class="ligneTableauLine ligneTableauHeader">
							<div id=Nom
								class="celluleTableauInTable celluleTableau celluleTableau200">Nom</div>
							<div
								class="celluleTableauInTable celluleTableau celluleTableau100">Prénom</div>
							<div
								class="celluleTableauInTable celluleTableau celluleTableau100">Promotion</div>
							<div
								class="celluleTableauInTable celluleTableau celluleTableau100">Année</div>
						</div>
						<c:forEach var="utilisateurDTO" items="${listeUtilisateur}"
							varStatus="numLigne">
							<c:set var="isAlternativeLigne" value="${numLigne.index%2>0}" />
							
						<a href="./UserForm?numligneutil=${numLigne.index}" class = "lienListe">
							<div
							
								class="ligneTableauLine <c:if test="${isAlternativeLigne}">ligneTableauAlternativLine</c:if><c:if test="${!isAlternativeLigne}">ligneTableauNormalLine</c:if>">
								<div
									class="celluleTableauInTable celluleTableau celluleTableau200">
								
									<c:out value="${utilisateurDTO.nom}" />
									
								</div>
								<div
									class="celluleTableauInTable celluleTableau celluleTableau100">
									<c:out value="${utilisateurDTO.prenom}" />
								</div>
								<div
									class="celluleTableauInTable celluleTableau celluleTableau100">
									<c:out value="${utilisateurDTO.promotion.intitule}" />
								</div>
								<div
									class="celluleTableauInTable celluleTableau celluleTableau100">
									<c:out value="${utilisateurDTO.promotion.annee}" />
								</div>
						</a>

								<%--
					<div class="celluleTableauInTable celluleTableau celluleTableau100">

						
						
						<form id="sup" action="./UserForm">
							<input type="hidden" name="ligne" value="${numLigne.index}"></input>
							<input type="hidden" id="nomUtilisateur" value="${utilisateurDTO.nom}"></input>
							<input type="hidden" id="prenomUtilisateur" value="${utilisateurDTO.prenom}"></input>
							<input type="submit" name="delete" value="supprimer"></input>
						</form> 
						

					</div>--%>
							</div>
						</c:forEach>
					</div>
				</div>
				<form action="./UserForm">
					<input type="submit" name="create" id="create" value="creer"></input>
				</form>
			</div>
		</div>
	</div>

</body>
</html>