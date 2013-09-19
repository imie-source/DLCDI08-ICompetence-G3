<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />
<link rel="stylesheet" href="JQuery/jquery-ui.css"></link>
<script type="text/javascript" src=JQuery/jquery-1.9.1.js></script>
<script type="text/javascript" src=JQuery/ui-1.10.3-jquery-ui.js></script>
<title>Gestion des Compétences</title>
<script>
$(document).ready(function(){
	$('.orange').mouseover(function(){
		$(this).css("color", "#48b9c7");})
		.mouseleave(function(){
			$(this).css("color", "#fdb515");});
	$('.bleu').mouseover(function(){
		$(this).css("color", "#ef3125");})
			.mouseleave(function(){
		$(this).css("color", "#48b9c7");});
	$('.rouge').mouseover(function(){
		$(this).css("color", "#48b9c7");})
			.mouseleave(function(){
		$(this).css("color", "#ef3125");});

	});
</script>
</head>
<body>
	<jsp:include page="HeaderTest.jsp" />
	<div class="contenu">
		<div class="titre">
			<h1>Bienvenue</h1>
		</div>
		<div class="liste">
			<div class="global">
				<div class="block accueil">
					<div class="info_site">
						<div class ="rouge">"Vos clients les moins contents constituent pour vous la plus grande source d’apprentissage." Bill Gates									
						</div>
						<div class = "bleu">"L'innovation, c'est une situation qu'on choisit parce qu'on a une passion brûlante pour quelque chose." Steve Jobs													
						</div>
						<div class ="orange">"Je choisirai un homme paresseux pour faire un travail difficile parce qu’il trouvera un moyen facile de le faire." Bill Gates
														
						</div>
						<div class ="bleu">"C'est plus marrant d'être un pirate que de s'engager dans la marine." Steve Jobs					
						</div>
						
						
						
					</div>
					
					

							<div class="image2">
							<img src="images/affiche_ce_informatique_0.png" width=250
								height=450 style="float: center; align: center" border="0" />
							</div>
					

				</div>
			</div>
		</div>
	</div>

</body>
</html>