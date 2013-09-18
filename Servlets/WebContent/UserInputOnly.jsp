<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
						<div id="nom_util">
							<h2>Nom :</h2> <input type="text" name="nom" required="required" value="${utilisateur.nom}"></input>
						</div>
						<div id="prenom_util">
							<h2>Prénom :</h2> <input type="text" name="prenom" required="required" value="${utilisateur.prenom}"></input>
						</div>
						<div id="date_nais_util">
							<h2>Date de naissance :</h2> <input type="text" name="dateNaissance" required="required" placeholder="ex. 16/12/1980" value="<fmt:formatDate value="${utilisateur.dateNaissance}" pattern="dd/MM/yyyy"/>"></input>
						</div>
						<div id="adresse_util">
							<h2> Adresse : </h2><input type="text" name="adresse" value="${utilisateur.adresse}"></input>
						</div>
						<div id="tel_util">
							<h2>Téléphone : </h2><input type="text" name="tel" value="${utilisateur.tel}"></input>
						</div>
						<div id="mail_util">
							<h2>Adresse mail :</h2> <input type="text" name="mail" value="${utilisateur.mail}"></input>
						</div>
						<div id="promotion_util">
							<h2>Promotion : </h2>
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
							<h2>Login : </h2><input type="text" name="login" value="${utilisateur.login}"></input>
						</div>
						<div id="password_util">
							<h2>Password : </h2><input type="password" name="password" value="${utilisateur.password}"></input>
						</div>				
		
