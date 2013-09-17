<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />
<title>Modification du projet</title>
</head>
<body>
<jsp:include page="HeaderTest.jsp" />
<div id="creation_projet">
	
			<div id="fiche_projet">
				<form method ="post" action = "./Projet">
					<jsp:include page="ProjetUpdateOnly.jsp" />
					<input type="hidden" name="numProjet" value="${utilisateurDTO.num}"> </input>
					<input type="submit" name="updateAction" value="Confirmer"></input>
				</form>
				
				<form action="./ProjetConsult.jsp">
					<input type="submit" value="retour"></input>
				</form>
			</div>
</div>
				
</body>
</html>