<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Projet</title>
</head>
<body>
<h1>ID PROJECT</h1>
Intitulé
<div>
<c:out value="${projetDTO.intitule}" />
</div>
Contenu
<div>
<c:out value="${projetDTO.description}" />
</div>
Chef de projet
<div>
<c:out value="${projetDTO.chefDeProjet.nom} ${projetDTO.chefDeProjet.prenom}" />
</div>
Avancement
<div>
<c:out value="${projetDTO.statutProjet.valeurStatut}" />
</div>


<h1>PARTICIPANTS</h1>
<c:forEach var="util" items="${listeUtil}">
<div>
<c:out value="${util.nom} ${util.prenom}" />
</div>
</c:forEach>
</body>
</html>