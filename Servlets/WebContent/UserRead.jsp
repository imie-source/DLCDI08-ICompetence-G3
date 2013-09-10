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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Utilisateur</title>
<script>
</script>
</head>
<body>
			<div id="lecture_utilisateur">
				<c:if test="${! empty utilisateur.num}">
					<jsp:include page="UserReadOnly.jsp"/>					
					<form action="./UserForm">
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input> 
						<input type="submit" name="update" value="modifier"></input>
					</form>
					<form action="./UserForm">
						<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input>
						<input type="submit" name="delete" value="supprimer"/>
					</form>
					<form action="./ListUserView">
						<input type="submit" value="retour"></input>
					</form>
				</c:if>
				<c:if test="${empty utilisateur.num}">
					<c:redirect url="/ListUserView" />
				</c:if>
			</div>
</body>
</html>