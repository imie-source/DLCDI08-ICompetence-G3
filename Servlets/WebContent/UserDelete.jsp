<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel=stylesheet type=text/css href=css/style.css />
<title>Insert title here</title>
</head>
<body>
<div id="lecture_utilisateur">
	<c:if test="${! empty utilisateur.num}">
		Etes-vous sûr de vouloir supprimer cet utilisateur ?
		<jsp:include page="UserReadOnly.jsp"/>
		<form action="./UserForm">
			<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input> 
			<input type="submit" name="deleteAction" value="supprimer"></input>		
		</form>
		<form action="./ListUserView">
			<input type="hidden" name="numUtilisateur" value="${utilisateur.num}"></input>
			<input type="submit" value="retour"></input>
		</form>
	</c:if>
	<c:if test="${empty utilisateur.num}">
		<c:redirect url="/ListUserView" />
	</c:if>
</div>
</body>
</html>