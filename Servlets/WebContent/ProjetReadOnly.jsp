<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="contenu">

		<div class="titre">
		<h1>Projet</h1>
		
		</div>
		<div class="liste">
		<div class="fiche">
			<div class="ficheGauche">
			<input type="hidden" name="numProjet" value="${projetDTO.num }"></input>
					<h1>ID PROJET</h1>
					<h2>Intitulé<h2>
					<div>
					<input type="text" readonly="readonly" name="intituleProjet" value="${projetDTO.intitule}"></input>
					</div>
					<h2>Contenu</h2>
					<div>
					<input type="text" readonly="readonly" name="descriptionProjet"  value="${projetDTO.description}"></input>
					</div>
					<h2>Chef de projet</h2>
					<div>
					<input type="text" readonly="readonly" name="chefProjet"  value="${projetDTO.chefDeProjet.nom} ${projetDTO.chefDeProjet.prenom}" ></input>
					</div>
					<h2>Avancement</h2>
					<div>
					<input type="text" readonly="readonly" name="statutProjet"  value="${projetDTO.statutProjet.valeurStatut}"></input>
					</div>
			</div>

		<div class = "ficheDroite">
					<div class="ficheHaut">
					
						<h1>PARTICIPANTS</h1>
						<c:forEach var="util" items="${listeUtil}" varStatus="utilProjet">
							<div>
							<a href="./UserForm?numligneutil=${utilProjet.index}">
								<input type="text" readonly="readonly" name="utilProjet"  value="${util.nom} ${util.prenom}" />
							</a>
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
</div>

</body>
</html>