<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="contenu">
<div class="titre">
<h1>Utilisateur</h1>
</div>
<div class="fiche">
			<div class="ficheGauche">ID Utilisateur 
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
						<div id="nom_util">
							Nom : <input type="text" name="nom" required="required" value="${utilisateur.nom}"></input>
						</div>
						<div id="prenom_util">
							Pr�nom : <input type="text" name="prenom" required="required" value="${utilisateur.prenom}"></input>
						</div>
						<div id="date_nais_util">
							Date de naissance :<input type="text" name="dateNaissance" required="required" placeholder="ex. 16/12/1980" value="<fmt:formatDate value="${utilisateur.dateNaissance}" pattern="dd/MM/yyyy"/>"></input>
						</div>
						<div id="adresse_util">
							Adresse : <input type="text" name="adresse" value="${utilisateur.adresse}"></input>
						</div>
						<div id="tel_util">
							T�l�phone :<input type="text" name="tel" value="${utilisateur.tel}"></input>
						</div>
						<div id="mail_util">
							Adresse mail : <input type="text" name="mail" value="${utilisateur.mail}"></input>
						</div>
						<div id="promotion_util">
							Promotion : 
							<select name="promotion">
								<c:forEach var="promotion" items="${ListePromo}">
									<c:if test="${utilisateur.promotion.num == promotion.num}">
										<option selected="selected" value="${promotion.num}"> ${promotion.intitule} ${promotion.annee}</option>
									 </c:if>
									<c:if test="${utilisateur.promotion.num != promotion.num}">
										<option value="${promotion.num}"> ${promotion.intitule} ${promotion.annee}</option>
									</c:if>
								</c:forEach>		
							</select>
						</div>
						<div id="login_util">
							Login : <input type="text" name="login" value="${utilisateur.login}"></input>
						</div>
						<div id="password_util">
							Password : <input type="password" name="password" value="${utilisateur.password}"></input>
						</div>
			</div>
			
			<div class = "ficheDroite">
					<div class="ficheHaut">
						<div id="comp_util">
						Comp�tences :
							<div>
								<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
									<div>
										<c:out value="${comp.competence} ${comp.nom }"></c:out>
									</div>
								</c:forEach>
								<div id="modal">
									<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
									<div>
										<c:out value="${comp.competence} ${comp.nom }"></c:out>
									</div>
								</c:forEach>
								</div>
								<button id="ajoutComp">Modifier</button>
								
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
					
			</div>
</div>
</div>					
