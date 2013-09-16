<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="contenu">
	<div class="titre">
		<h1>Competence</h1>
	</div>
	<div class="liste">
	<div class="fiche">
		<div class="ficheGauche">
			ID Competence
			<div id="fiche_competence">
				<input type="hidden" name="numCompetence" value="${competence.num }"></input>
				<div id="nom_competence">
					Nom : <input type="text" readonly="readonly" name="nom"
						value="${competence.nom}"></input>
				</div>
				<div id="competence_domaine">
					Domaine : <input type="text" readonly="readonly" name="competenceDomaine"
						value="${competence.competenceDomaine.nom}"></input>
				</div>
			</div>
		</div>
		</div>
		<div class="ficheDroite">
			<div class="ficheHaut">

				<div id="comp_util">
					Utilisateurs :
					<div>
						<c:forEach var="comp" items="${ListeUtilNiv}" varStatus="numLigne">
							<div>
								<a href="./UserForm?numligneutil=${numLigneUtil.index}"> <c:out
										value="${niv.utilisateur.nom}"></c:out>
										<c:out value="${niv.utilisateur.prenom}"></c:out>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			

</div>





		</div>
	</div>