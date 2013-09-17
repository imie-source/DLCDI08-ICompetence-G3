<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="contenu">
<div class="titre">
<h1>projet</h1>
</div>
<div class="fiche">
			<div class="ficheDroite">ID Comp�tence
						<input type="hidden" name="numCompetence" value="${competence.num }"></input>
						<div id="nom_comp">
							Nom : <input type="text" name="nom" value="${competence.nom}"></input>
						</div>
						<div id="competence_domaine">
							Domaine comp�tence : <select name="competenceDomaine">
								<c:forEach var="competenceDomaine" items="${listComp}">
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
