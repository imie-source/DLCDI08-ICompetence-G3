<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />
<title>Projet</title>
</head>
<body>
<jsp:include page="HeaderTest.jsp" />
			<div id="lecture_projet">
				<c:if test="${! empty projetDTO.num}">
					<jsp:include page="ProjetReadOnly.jsp"/>					
					<form method ="get" action="./Projet">
						<input type="hidden" name="numProjet" value="${projetDTO.num}"></input> 
						<input type="submit" name="update" value="modifier"></input>
					</form>
					<form action="./Projet">
						<input type="hidden" name="numProjet" value="${projetDTO.num}"></input>
						<input type="submit" name="delete" value="supprimer"/>
					</form>
					<form action="./ListProjetView">
						<input type="submit" value="retour"></input>
					</form>
				</c:if>
				<c:if test="${empty projetDTO.num}">
					<c:redirect url="./ListProjetView" />
				</c:if>
			</div>


		
</body>
</html>