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
<link rel="stylesheet" href=JQuery/jquery-ui.css></link>
<script type="text/javascript" src=JQuery/jquery-1.9.1.js></script>
<script type="text/javascript" src=JQuery/ui-1.10.3-jquery-ui.js></script>
<title>Insert title here</title>
<script>
$(document).ready(function() {
			// Du code en jQuery va pouvoir être tapé ici !

			/* var $nom = $('#nom'), $envoi = $('#envoi'), $reset = $('#rafraichir'), $erreur = $('#erreur'), $champ = $('.champ');

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
			} */
			$( "#modal" ).dialog({
			     autoOpen: false,
			      show: {
			        effect: "blind",
			        duration: 1000
			      },
			      hide: {
			        effect: "explode",
			        duration: 1000
			      }
			    });
			  $( "#modifComp" ).click(function() {
			   		$( "#modal" ).dialog( "open" );
			  });

			  $( "#modal2" ).dialog({
				     autoOpen: false,
				      show: {
				        effect: "blind",
				        duration: 1000
				      },
				      hide: {
				        effect: "explode",
				        duration: 1000
				      }
				    });
			$( "#ajoutComp" ).click(function() {
				     $( "#modal2" ).dialog( "open" );
				  });
		});
</script>
</head>
<body>
<jsp:include page="HeaderTest.jsp" />
<div id="creation_utilisateur">
	<c:if test="${! empty utilisateur.num}">
			<div id="fiche_utilisateur">
				<form method="post" action="./UserForm">
					<jsp:include page="UserInputOnly.jsp" />
					<input type="hidden" name="numUtilisateur" value=<c:out value="${utilisateurDTO.num}"/>> </input>
					<input type="submit" name="updateAction" value="Confirmer"></input>
				</form>	
				<form action="./ListUserView">
					<input type="submit" value="retour"></input>
				</form>
			</div>
			<div class = "ficheDroite">
				<div class="ficheHaut">
					<div id="comp_util">
					Compétences :
						<div>
							<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
								<div id="modifComp">
									<c:out value="${comp.competence.nom} ${comp.nom }"></c:out>
								</div>
							</c:forEach>
								<div id="modal">
									<div>
										<c:out value="${comp.competence.nom}"></c:out>
											<select name="niveau">
												<c:forEach var="niveau" items="${ListeNiveau}">
													<c:if test="${comp.num == niveau.num}">
														<option selected="selected" value="${niveau.num}"> ${niveau.nom}</option>
									 				</c:if>
													<c:if test="${comp.num != niveau.num}">
														<option value="${niveau.num}"> ${niveau.nom}</option>
													</c:if>
												</c:forEach>		
											</select>
									</div>
									<input type="hidden" name="numComp" value="${comp.competence.num}"> </input>
									<input type="submit" name="updateAction" value="Ok"></input>
								</div>
						</div>
						<div id="modal2">
							<form method="post" action="./UserForm">
								<select name="comp">
									<c:forEach var="comp" items="${ListeComp}">
										<option value="${comp.num}"> ${comp.nom}</option>
									</c:forEach>		
								</select>
								<select name="niveau">
									<c:forEach var="niveau" items="${ListeNiveau}">
											<option value="${niveau.num}"> ${niveau.nom}</option>
									</c:forEach>							
								</select>
								<input type="hidden" name="numUtil" value="${utilisateur.num}"></input>
								<input type="submit" name="updateAction" value="Enregistrer"></input>
							</form>
						</div>
							<button id="ajoutComp">Ajouter une compétence</button>
					</div>
				</div>
			</div>
			<div class="ficheCentre">	
			Projets
				<div>
					<c:forEach var="projet" items="${ListeUtilProjet}">
						<div>
							<c:out value="${projet.intitule}"></c:out>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="ficheBas">
			Invitations:
			</div>
	</c:if>
	<c:if test="${empty utilisateur.num}">
		<c:redirect url="/ListUserView"/>
	</c:if>
</div>
</body>
</html>