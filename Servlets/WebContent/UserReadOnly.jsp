<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="contenu">
<div class="titre">
<h1>Utilisateur</h1>
</div>
<div class="liste">
<div class="fiche">
			<div class="ficheGauche">
			<h1>ID Utilisateur </h1>
					<div id="fiche_utilisateur">	
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
					<div id="nom_util">
						<h2>Nom :</h2> <input type="text" readonly="readonly" name="nom" value="${utilisateur.nom}"></input>
					</div>
					<div id="prenom_util">
						<h2>Prénom : </h2><input type="text" readonly="readonly" name="prenom" value="${utilisateur.prenom}"></input>
					</div>
					<div id="date_nais_util">
						<h2>Date de naissance :</h2><input type="text" readonly="readonly" name="dateNaissance" value="<fmt:formatDate value="${utilisateur.dateNaissance}" pattern="dd/MM/yyyy"/>"></input>
					</div>
					<div id="adresse_util">
						<h2>Adresse : </h2><input type="text" readonly="readonly" name="adresse" value="${utilisateur.adresse}"></input>
					</div>
					<div id="tel_util">
						<h2>Téléphone : </h2><input type="text" readonly="readonly" name="tel" value="${utilisateur.tel}"></input>
					</div>
					<div id="mail_util">
						<h2>Adresse mail : </h2><input type="text" readonly="readonly" name="mail" value="${utilisateur.mail}"></input>
					</div>
					<div id="promotion_util">
						<h2>Promotion : </h2><input type="text" readonly="readonly" name="promotion" value="${utilisateur.promotion.intitule} ${utilisateur.promotion.annee}"></input>
					</div>
					<div id="login_util">
						<h2>Login : </h2><input type="text" readonly="readonly" name="login" value="${utilisateur.login}"></input>
					</div>
					<div id="password_util">
						<h2>Password : </h2><input type="text" readonly="readonly" name="password" value="${utilisateur.password}"></input>
					</div>
					</div>
			</div>
			
			<div class = "ficheDroite">
					<div class="ficheHaut">
					
						<div id="comp_util">
						<h1>Compétences :</h1>
						<div>
							<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
								<div>
									<c:out value="${comp.competence.nom} ${comp.nom}"></c:out>
								</div>
							</c:forEach>
						</div>
						</div>
					</div>
					
					<div class="ficheCentre">				
					<h1>Projet :</h1>
						<div>
							<c:forEach var="projet" items="${ListeUtilProjet}">
								<div>
									<c:out value="${projet.intitule}"></c:out>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="ficheBas">
					Invitations au projet<br/>
					Choisir un projet : 
						<div>
						<form action = "./Projet" method="post">
						<select name="projetForInvitation">
							<c:forEach var ="projetForInvit" items = "${listeProjetForInvit}">
									<option value = "${projetForInvit.num}"> ${projetForInvit.intitule}</option>
							</c:forEach>
						</select>
						<%-- <input type="hidden" name ="numProjetForInvit" value = "${projetForInvit.num}"></input>--%>
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input>
						<input type="submit" name="envoyerInvite" value="envoyer"></input>					
						</form>
						
						</div>
					</div>
		</div>		
	</div>
	</div>
</div>