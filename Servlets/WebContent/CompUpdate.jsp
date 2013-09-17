<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />
<title>Insert title here</title>
<script>
jQuery(document)
.ready(
		function() {
			// Du code en jQuery va pouvoir être tapé ici !

			var $nom = $('#nom'), $envoi = $('#envoi'), $reset = $('#rafraichir'), $erreur = $('#erreur'), $champ = $('.champ');

			$champ.keyup(function() {
				if ($(this).val().length < 5) { // si la chaîne de caractères est inférieure à 5
					$(this).css({ // on rend le champ rouge
						borderColor : 'red',
						color : 'red'
					});
				} else {
					$(this).css({ // si tout est bon, on le rend vert
						borderColor : 'green',
						color : 'green'
					});
				}
			});

			$envoi.click(function(e) {
				//e.preventDefault(); // on annule la fonction par défaut du bouton d'envoi

				// puis on lance la fonction de vérification sur tous les champs :
				verifier($nom);

			});

			$reset.click(function() {
				$champ.css({ // on remet le style des champs comme on l'avait défini dans le style CSS
					borderColor : '#ccc',
					color : '#555'
				});
				$erreur.css('display', 'none'); // on prend soin de cacher le message d'erreur
			});

			function verifier(champ) {
				if (champ.val() == "") { // si le champ est vide
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
<jsp:include page="HeaderTest.jsp" />
<div id="modif_competence">
	<c:if test="${! empty competence.num}">
			<div id="fiche_competence">
				<form method="post" action="./CompForm">
					<jsp:include page="CompInputOnly.jsp" />
						<input type="hidden" name="numCompetence" value=<c:out value="${competence.num}"/>> </input>
						<input type="submit" name="updateAction" value="Confirmer"></input>
				</form>
				<form action="./ListCompView">
					<input type="submit" value="retour"></input>
				</form>
			</div>
	</c:if>
	<c:if test="${empty competence.num}">
		<c:redirect url="/ListCompView"/>
	</c:if>
</div>
</body>
</html>