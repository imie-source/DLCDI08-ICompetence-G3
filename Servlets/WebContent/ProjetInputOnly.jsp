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
					Intitulé
					<div>
					<input type="text" name="intituleProjet" value="${projetDTO.intitule}"></input>
					</div>
					Contenu
					<div>
					<input type="text" name="descriptionProjet"  value="${projetDTO.description}"></input>
					</div>
					
					Chef de projet
					<div>
						<select name="chefProjet">
							<c:forEach var="chefProjet" items="${listeForChef}">
							
								<c:if test="${projetDTO.chefDeProjet.num == chefProjet.num}">
								<option selected="selected" value= "${chefProjet.num}"> ${chefProjet.nom} ${chefProjet.prenom}</option>
								</c:if>
								
								
								<c:if test="${projetDTO.chefDeProjet.num != chefProjet.num}">
								<option value= "${chefProjet.num }"> ${chefProjet.nom} ${chefProjet.prenom}</option>
								</c:if>
							</c:forEach>		
						</select>
					</div>
																		
					Avancement
					<div>
					
						<select name = "statutProjet">
							<c:forEach var="statutProjet" items="${listeStatut}">

								<c:if test="${projetDTO.statutProjet.num == statutProjet.num}">
									<option value="${statutProjet.num}" selected="selected"> ${statutProjet.valeurStatut}</option>
								</c:if>
								
								<c:if test="${projetDTO.statutProjet.num != statutProjet.num}">
									<option value="${statutProjet.num}"> ${statutProjet.valeurStatut}</option>
								</c:if>
								
							</c:forEach>
						</select>					
					</div>
			</div>

		<div class = "ficheDroite">
					<div class="ficheHaut">
					
						<h1>PARTICIPANTS</h1>
						<c:forEach var="util" items="${listeUtil}" varStatus="numLigne">
							<div>
							<input type="text"  name="utilProjet"  value="${util.nom} ${util.prenom}" />
							</div>
						</c:forEach>
					</div>
					<div class="ficheCentre">Invitations
					</div>
					<div class="ficheBas">
					</div>
		</div>
	</div>
	
		<div class = "boutons">
		</div>	
</div>
</div>

