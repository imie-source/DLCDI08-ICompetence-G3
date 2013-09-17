<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="fr.imie.formation.DTO.CompetenceDTO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel=stylesheet type=text/css href=css/style.css />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel="stylesheet" href="../css/jquery.treeview.css" />
<link rel="stylesheet" href="../css/red-treeview.css" />

<script src="../lib/jquery.js" type="text/javascript"></script>
<script src="../lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../jquery.treeview.js" type="text/javascript"></script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Compétences</title>

<script type="text/javascript">
	$(function() {
		$("#navigation").treeview({
			persist : "location",
			collapsed : true,
			unique : true
		});
	});
</script>

</head>
<body>

	<jsp:include page="HeaderTest.jsp" />
	<div class="contenu">
		<div class="titre">
			<h1>Liste des compétences</h1>


			<ul id="tree">
					<ul id="navigation">
						<c:forEach var="competenceDTO" items="${listeCompetence}"
							varStatus="numLigneComp">
							<c:set var="isAlternativeLigne" value="${numLigneComp.index%2>0}" />
							<div
								class="ligneTableauLine <c:if test="${isAlternativeLigne}">ligneTableauAlternativLine</c:if><c:if test="${!isAlternativeLigne}">ligneTableauNormalLine</c:if>">
								<div
									class="celluleTableauInTable celluleTableau celluleTableau200">
									<ul>
										<li><a
											href="./CompForm?numLigneComp=${numLigneComp.index}"> <c:out
													value="${competenceDTO.nom}" /></a></li>
									</ul>
								</div>

							</div>
						</c:forEach>

					</ul>
			</ul>
		</div>
				<form action="./CompForm">
					<input type="submit" name="create" id="create" value="creer"></input>
				</form>
		</div>
		</div>
	
</body>
</html>