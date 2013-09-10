

				<form method="post" action="./UserForm">
					<input type="hidden" name="numUtilisateur" value="${utilisateur.num }"></input>
						<div id="nom_util">
							Nom : <input type="text" name="nom" value="${utilisateur.nom}"></input>
						</div>
						<div id="prenom_util">
							Prénom : <input type="text" name="prenom" value="${utilisateur.prenom}"></input>
						</div>
						<div id="date_nais_util">
							Date de naissance :<input type="text" name="dateNaissance" value="${utilisateur.dateNaissance}"></input>
						</div>
						<div id="adresse_util">
							Adresse : <input type="text" name="adresse" value="${utilisateur.adresse}"></input>
						</div>
						<div id="tel_util">
							Téléphone :<c:out value="${utilisateur.tel}"></c:out>
						</div>
						<div id="mail_util">
							Adresse mail : <c:out value="${utilisateur.mail}"></c:out>
						</div>
						<div id="promotion_util">
							Promotion : <c:out value="${utilisateur.promotion.intitule} ${utilisateur.promotion.annee}"></c:out>
						</div>
						<div id="login_util">
							Login : <c:out value="${utilisateur.login}"></c:out>
						</div>
						<div id="password_util">
							Password :
							<c:out value="${utilisateur.password}"></c:out>
						</div>
					</form>
