<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="fr.imie.formation.DTO.UtilisateurDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel=stylesheet type=text/css href=css/style.css />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Utilisateur</title>
<script>
	jQuery(document).ready(function(){
    // Du code en jQuery va pouvoir être tapé ici !

		var $nom = $('#nom'),
		 	$envoi = $('#envoi'),
	        $reset = $('#rafraichir'),
	        $erreur = $('#erreur'),
			$champ = $('.champ');
 
    $champ.keyup(function(){
        if($(this).val().length < 5){ // si la chaîne de caractères est inférieure à 5
            $(this).css({ // on rend le champ rouge
                borderColor : 'red',
           		color : 'red'
            });
         }
         else{
             $(this).css({ // si tout est bon, on le rend vert
             borderColor : 'green',
             color : 'green'
         });
         }
    });
 
    $envoi.click(function(e){
        //e.preventDefault(); // on annule la fonction par défaut du bouton d'envoi
 
        // puis on lance la fonction de vérification sur tous les champs :
        verifier($nom);

    });
 
    $reset.click(function(){
        $champ.css({ // on remet le style des champs comme on l'avait défini dans le style CSS
            borderColor : '#ccc',
            color : '#555'
        });
        $erreur.css('display', 'none'); // on prend soin de cacher le message d'erreur
    });
 
    function verifier(champ){
        if(champ.val() == ""){ // si le champ est vide
            $erreur.css('display', 'block'); // on affiche le message d'erreur
            champ.css({ // on rend le champ rouge
                borderColor : 'red',
                color : 'red'
            });
        }
    }
		
	});
</script> 
</head>
<body>
<c:choose>
<c:when test="${action == 'read'}">
<div id="lecture_utilisateur">
<c:if test="${! empty utilisateur.num}">
	<div id="fiche_utilisateur">
	
	<div id="nom_util">
	Nom : <c:out value="${utilisateur.nom}"></c:out>
	</div>
	<div id ="prenom_util">
	Prénom : <c:out value="${utilisateur.prenom}"></c:out>
	</div>
	<div id="date_nais_util">
	Date de naissance : <c:out value="${utilisateur.dateNaissance}"></c:out>
	</div>
	<div id ="adresse_util">
	Adresse : <c:out value="${utilisateur.adresse}"></c:out>
	</div>
	<div id="tel_util">
	Téléphone : TODO!!!!
	</div>
	<div id="mail_util">
	Adresse mail : TODO!!
	</div>
	<div id="promotion_util">
	Promotion : <c:out value="${utilisateur.promotion.intitule} ${utilisateur.promotion.annee}"></c:out>
	</div>
	<div id="login_util">
	Login : <c:out value="${utilisateur.login}"></c:out>
	</div>
	<div id="password_util">
	Password : <c:out value="${utilisateur.password}"></c:out>
	</div>
	</div>
	<div id="comp_util">
	Compétences :
	<div > 
	<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
	<div><c:out value="${comp.competence} ${comp.nom }"></c:out>
	</div>
	</c:forEach>
	</div>
	</div>
	<form action="./UserForm">
			<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input> 
			<input type="submit" name="update" value="modifier"></input>
	</form>
	<form action="./ListUserView"> 
			<input type="submit" value="retour"></input>
	</form>
	</c:if>
</div>
	<c:if test="${empty utilisateur.num}">
	<c:redirect url="/ListUserView" />
	</c:if>
	</c:when>
	<c:when test="${action == 'update'}">
	<form method="post" action="./UserForm">

			<c:if test="${! empty utilisateur.num}">
			<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
			<input type="text" name="nom" value="${utilisateur.nom}"></input>
			<br />
			<input type="text" name="prenom" value="${utilisateur.prenom}"></input> 
			<br />
			<br />
			<input type="submit" name="updateAction" value="modifier"></input>
			<br />
			</c:if>
		<c:if test="${empty utilisateur.num}">
			<c:redirect url="/ListUserView" />
		</c:if>
	</form>
	</c:when>
	<c:when test="${action == 'add'}">
	<form method="post" action="./UserForm">
		<input type="text" id=nom name="nom" class="champ"></input> 
		<br />
		<input type="text" id=prenom name="prenom" class="champ"></input> 
		<br />
		<br />
		<input type="submit" id="envoi" name="createAction" value="ajouter"></input>
		<input type="reset" id="rafraichir" value="rafraichir" />
		<br />
	</form>
	</c:when>
	<c:when test="${action == 'delete'}">
	<c:if test="${! empty utilisateur.num}">
	Etes-vous sûr de vouloir supprimer cet utilisateur ?
	<br />
	<br />
	NOM = <c:out value="${utilisateur.nom}"></c:out>
	<br />
	PRENOM = <c:out value="${utilisateur.prenom}"></c:out>
	<br />
	<br />
	<form action="./UserForm">
			<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input> 
			<input type="submit" name="deleteAction" value="supprimer"></input>
	</form>
	<form action="./ListUserView"> 
			<input type="submit" value="retour"></input>
	</form>
	</c:if>
	<c:if test="${empty utilisateur.num}">
		<c:redirect url="/ListUserView" />
	</c:if>
	</c:when>
	<c:when test="${action == 'updateAction' || action == 'createAction' || action == 'deleteAction'}">
			<c:redirect url="/ListUserView"/>
	</c:when>
</c:choose>
</body>
</html>