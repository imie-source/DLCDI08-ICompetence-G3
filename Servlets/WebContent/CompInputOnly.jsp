<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="contenu">
<div class="titre">
<h1>Compétences</h1>
</div>
<div class="fiche">
			<div class="ficheDroite">
						<div id="nom_comp">
							Nom : <input type="text" name="nom" value="${competence.nom}"></input>
						</div>
						<div id="competence_domaine">
							Domaine compétence :
							<select name="competenceDomaine">
							<option></option>
								<c:forEach var="competenceDomaine" items="${ListComp}">
									<c:if test="${competence.competenceDomaine.num == competenceDomaine.num}">
										<option selected="selected" value="${competenceDomaine.num}"> ${competenceDomaine.nom}</option>
									 </c:if>
									<c:if test="${competence.competenceDomaine.num != competenceDomaine.num}">
										<option value="${competenceDomaine.num}"> ${competenceDomaine.nom}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
			</div>	
</div>
</div>					
