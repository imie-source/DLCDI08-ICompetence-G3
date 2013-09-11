<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="contenu">

		<div class="titre">
		<h1>Projet</h1>
		</div>
		
		<div class="fiche">
			<div class="ficheGauche">
			<input type="hidden" name="numProjet" value="${projetDTO.num }"></input>
					<h1>ID PROJET</h1>
					Intitulé
					<div>
					<c:out value="${projetDTO.intitule}" />
					</div>
					Contenu
					<div>
					<c:out value="${projetDTO.description}" />
					</div>
					Chef de projet
					<div>
					<c:out value="${projetDTO.chefDeProjet.nom} ${projetDTO.chefDeProjet.prenom}" />
					</div>
					Avancement
					<div>
					<c:out value="${projetDTO.statutProjet.valeurStatut}" />
					</div>
			</div>

		<div class = "ficheDroite">
					<div class="ficheHaut">
					
						<h1>PARTICIPANTS</h1>
						<c:forEach var="util" items="${listeUtil}">
						<div>
						<c:out value="${util.nom} ${util.prenom}" />
						</div>
						</c:forEach>
					</div>
					<div class="ficheCentre">
					</div>
					<div class="ficheBas">
					</div>
		</div>
	</div>
	
		<div class = "boutons">
		</div>	
</div>

</body>
</html>