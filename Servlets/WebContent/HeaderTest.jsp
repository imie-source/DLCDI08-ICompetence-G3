
<div class="chapeau">
<a href="Accueil.jsp"/>
	<div class="logo">
		<img src="images/imieLogo.png" />
	</div>
	<div class="titreMenu">
		<div class="titreChapeau">
			<h1>
				<span class="kill">s</span>kills manager
			</h1>
		</div>
		<div class="menu">
			<a href="./ListProjetView" class = "onglet">projets</a> 
			<a href="./ListUserView" class = "onglet">membres</a> 
			<a href="./ListCompView" class = "onglet"> competences</a>
		</div>
	</div>
	
	
	<div class="connexion">
		<c:if test="${empty user}">
			<div id="fiche_utilisateur">
				<form action="${redirectUrlLogin}">
					Pseudo <input id="userLogin" name="userLogin" type="text"></input>
					<br /> Mot de passe <input id="userPassword" name="userPassword"
						type="text"></input> <br /> <input type="submit"
						name="loginButton" value="connexion"></input>
				</form>
				<br /> <span>${errorMessage}</span>
			</div>
		</c:if>
		<c:if test="${user!=null}">

		</c:if>

	</div>
</div>
