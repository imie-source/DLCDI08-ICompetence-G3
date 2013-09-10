<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel=stylesheet type=text/css href=css/style.css />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Projets</title>
</head>
<body>

<div class="tableauContainer">
		<div class="tableau">

			<div class="ligneTableauLine ligneTableauHeader">
			<div id=Competence class="celluleTableauInTable celluleTableau celluleTableau200">Competence</div>
			</div>

			<c:forEach var="competenceDTO" items="${listeCompetence}"
				varStatus="numLigneComp">
				<c:set var="isAlternativeLigne" value="${numLigneComp.index%2>0}" />
					<div class="ligneTableauLine <c:if test="${isAlternativeLigne}">ligneTableauAlternativLine</c:if><c:if test="${!isAlternativeLigne}">ligneTableauNormalLine</c:if>">
					<div class="celluleTableauInTable celluleTableau celluleTableau200">
						<a href="./CompForm?numLigneComp=${numLigneComp.index}">
							<c:out value="${competenceDTO.nom}" />
						</a>
					</div>
				</div>
			</c:forEach>
			
			</div>			
</div>

</body>
</html>