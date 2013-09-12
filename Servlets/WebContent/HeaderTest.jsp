
<div class="chapeau">
	<div class="logo">
		<img src="images/imie.jpg" />
	</div>
	<div class="titreMenu">
		<div class="titreChapeau">
			<h1>
				<span class="kill">s</span>kills manager
			</h1>
		</div>
		<div class="menu">
			<a href="./ListProjetView">projets</a> <a href="./ListUserView">
				membres</a> <a href="./ListCompView"> competences</a>
		</div>
	</div>
	
	
	<div class="connexion">
		<c:if test="${empty user}">
			<div id="fiche_utilisateur">
				<form action="${redirectUrlLogin}">
					Pseudo <input id="userLogin" name="userLogin" type="text"></input>
					<br /> Mot de passe <input id="userPassword" name="userPassword"
						type="text"></input> <br /> <input type="submit"
						name="loginButton" value="loginValue"></input>
				</form>
				<br /> <span>${errorMessage}</span>
			</div>
		</c:if>
		<c:if test="${user!=null}">

		</c:if>

	</div>
</div>