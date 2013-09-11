<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="fiche_competence">	
	<input type="hidden" name="numCompetence" value="${competence.num }"></input>
<div id="nom_util">
	Competence : <input type="text" readonly="readonly" name="nom" value="${competence.nom}"></input>
</div>
</div>
<div id="util_comp">
	Utilisateurs :
		<div>
			<c:forEach var="niv" items="${listNiveauUtil}" varStatus="numLigne">
				<div>
					<c:out value="${niv.utilisateur.nom}"></c:out>
				</div>
			</c:forEach>
		</div>
</div>