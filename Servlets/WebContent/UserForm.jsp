<?xml version="1.0" encoding="UTF-8" ?>
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
</head>
<body>

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

	<%
		if (request.getAttribute("action").equals("read")) {

			UtilisateurDTO utilisateurDTO = (UtilisateurDTO) request
					.getAttribute("utilisateur");
			if (utilisateurDTO != null) {
	%>
	NOM =
	<%=utilisateurDTO.getNom()%>
	<br />
	PRENOM =
	<%=utilisateurDTO.getPrenom()%>
	<br />
	<br />
	<form action="./UserForm">
			<input type="hidden" name="numUtilisateur" value=<%=utilisateurDTO.getNum()%>></input> 
			<input type="submit" name="update" value="modifier"></input>
	</form>
	<form action="./ListUserView"> 
			<input type="submit" value="retour"></input>
	</form>

	<%
		} else {
	%>
	<%
		response.sendRedirect("/ListUserView");
	%>
	<%
		}
		} else if (request.getAttribute("action").equals("update")) {
	%>
	<form method="post" action="./UserForm">

		<%
			UtilisateurDTO utilisateurDTO = (UtilisateurDTO) request
						.getAttribute("utilisateur");
				if (utilisateurDTO != null) {
		%>
		<input type="hidden" name="numUtilisateur" value="<%=utilisateurDTO.getNum()%>"></input>
		<input type="text" name="nom" value="<%=utilisateurDTO.getNom()%>"></input>
		<br />
		<input type="text" name="prenom" value="<%=utilisateurDTO.getPrenom()%>"></input> 
		<br />
		<br />
		<input type="submit" name="updateAction" value="modifier"></input>
		<br />
		<%
			} else {
		%>
		<%
			response.sendRedirect("./ListUserView");
		%>
		<%
			}
		%>
	</form>
	<%
		} else if (request.getAttribute("action").equals("add")) {
	%>

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
	<%
		} else if (request.getAttribute("action").equals("delete")) {

			UtilisateurDTO utilisateurDTO = (UtilisateurDTO) request
					.getAttribute("utilisateur");
			if (utilisateurDTO != null) {
	%>
	
	Etes-vous sûr de vouloir supprimer cet utilisateur ?
	<br />
	<br />
	NOM =
	<%=utilisateurDTO.getNom()%>
	<br />
	PRENOM =
	<%=utilisateurDTO.getPrenom()%>
	<br />
	<br />
	<form action="./UserForm">
			<input type="hidden" name="numUtilisateur" value=<%=utilisateurDTO.getNum()%>></input> 
			<input type="submit" name="deleteAction" value="supprimer"></input>
	</form>
	<form action="./ListUserView"> 
			<input type="submit" value="retour"></input>
	</form>

	<%
		}
	}
		else if ((request.getAttribute("action").equals("updateAction"))
				|| (request.getAttribute("action").equals("createAction"))
				|| (request.getAttribute("action").equals("deleteAction"))) {

			response.sendRedirect("./ListUserView");

		}
	%>

</body>
</html>