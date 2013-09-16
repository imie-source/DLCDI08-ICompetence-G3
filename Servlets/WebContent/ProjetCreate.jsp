<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/styleTestFiche.css" />
<link rel=stylesheet type=text/css href=css/style.css />
<title>Insert title here</title>
</head>
<body>
<jsp:include page="HeaderTest.jsp" />
<form method="post" action="./Projet">
				<jsp:include page="ProjetInputOnly.jsp" />
					<input type="submit" id="envoi" name="createAction" value="ajouter"></input> 
					<input type="reset" id="rafraichir" value="rafraichir"/>
			</form>

</body>
</html>