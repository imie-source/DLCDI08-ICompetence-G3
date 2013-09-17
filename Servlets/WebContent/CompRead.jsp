<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="fr.imie.formation.DTO.UtilisateurDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel=stylesheet type=text/css href=css/style.css />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Competence</title>
<script>
	
</script>
</head>
<body>
	<jsp:include page="HeaderTest.jsp" />
	<div id="lecture_competence">
		<c:if test="${! empty competence.num}">
			<jsp:include page="CompReadOnly.jsp" />
			<form action="./CompForm">
				<input type="hidden" name="numComp" value="${competence.num}"></input>
				<input type="submit" name="update" value="modifier"></input>
			</form>
			<form action="./CompForm">
				<input type="hidden" name="numComp" value="${competence.num}"></input>
				<input type="submit" name="delete" value="supprimer" />
			</form>
			<form action="./ListCompView">
				<input type="submit" value="retour"></input>
			</form>
		</c:if>
		<c:if test="${empty competence.num}">
			<c:redirect url="/ListCompView" />
		</c:if>
	</div>
</body>
</html>