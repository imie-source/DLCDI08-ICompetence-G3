<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="fiche_utilisateur">	
	<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
<div id="nom_util">
	Nom : <input type="text" readonly="readonly" name="nom" value="${utilisateur.nom}"></input>
</div>
<div id="prenom_util">
	Prénom : <input type="text" readonly="readonly" name="prenom" value="${utilisateur.prenom}"></input>
</div>
<div id="date_nais_util">
	Date de naissance :<input type="text" readonly="readonly" name="dateNaissance" value="${utilisateur.dateNaissance}"></input>
</div>
<div id="adresse_util">
	Adresse : <input type="text" readonly="readonly" name="adresse" value="${utilisateur.adresse}"></input>
</div>
<div id="tel_util">
	Téléphone :<input type="text" readonly="readonly" name="tel" value="${utilisateur.tel}"></input>
</div>
<div id="mail_util">
	Adresse mail : <input type="text" readonly="readonly" name="mail" value="${utilisateur.mail}"></input>
</div>
<div id="promotion_util">
	Promotion : <input type="text" readonly="readonly" name="promotion" value="${utilisateur.promotion.intitule} ${utilisateur.promotion.annee}"></input>
</div>
<div id="login_util">
	Login : <input type="text" readonly="readonly" name="login" value="${utilisateur.login}"></input>
</div>
<div id="password_util">
	Password : <input type="text" readonly="readonly" name="password" value="${utilisateur.password}"></input>
</div>
</div>
<div id="comp_util">
	Compétences :
		<div>
			<c:forEach var="comp" items="${ListeCompNiv}" varStatus="numLigne">
				<div>
					<c:out value="${comp.competence} ${comp.nom }"></c:out>
				</div>
			</c:forEach>
		</div>
</div>
<div>
	Projet :
		<div>
			<c:forEach var="projet" items="${ListeUtilProjet}">
				<div>
					<c:out value="${projet.intitule}"></c:out>
				</div>
			</c:forEach>
		</div>
</div>