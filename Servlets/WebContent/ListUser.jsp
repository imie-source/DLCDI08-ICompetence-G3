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
<link rel=stylesheet type="text/css" href="style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<title>Liste des Utilisateurs</title>
</head>
<body>
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
	<div class="tableauContainer">
		<div class="tableau">

			<div class="ligneTableauLine ligneTableauHeader">
				<div id=Nom
					class="celluleTableauInTable celluleTableau celluleTableau200">Nom</div>
				<div class="celluleTableauInTable celluleTableau celluleTableau100">Prénom</div>
				<div class="celluleTableauInTable celluleTableau celluleTableau100">Promotion</div>
				<div class="celluleTableauInTable celluleTableau celluleTableau100">Année</div>
			</div>
			<c:forEach var="utilisateurDTO" items="${listeUtilisateur}"
				varStatus="numLigne">
				<c:set var="isAlternativeLigne" value="${numLigne.index%2>0}" />
					<div class="ligneTableauLine <c:if test="${isAlternativeLigne}">ligneTableauAlternativLine</c:if><c:if test="${!isAlternativeLigne}">ligneTableauNormalLine</c:if>">
					<div class="celluleTableauInTable celluleTableau celluleTableau200">
						<a href="./UserForm?numligne=${numLigne.index}">
							<c:out value="${utilisateurDTO.nom}" />
						</a>
					</div>
					<div class="celluleTableauInTable celluleTableau celluleTableau100">
						<c:out value="${utilisateurDTO.prenom}" />
					</div>
					<div class="celluleTableauInTable celluleTableau celluleTableau100">
						<c:out value="${utilisateurDTO.promotion.intitule}"/>
					</div>
					<div class="celluleTableauInTable celluleTableau celluleTableau100">
						<c:out value="${utilisateurDTO.promotion.annee}"/>
					</div>
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
</body>
</html>