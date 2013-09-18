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
<div id="lecture_competence">
	<c:if test="${! empty competence.num}">
		Etes-vous sûr de vouloir supprimer cette compétence?
		<jsp:include page="CompReadOnly.jsp"/>
		<form method="post" action="./CompForm">
			<input type="hidden" name="numComp" value="${competence.num}"></input> 
			<input type="submit" name="deleteAction" value="supprimer"></input>		
		</form>
		<form action="./ListCompView">
			<input type="hidden" name="numComp" value="${competence.num}"></input>
			<input type="submit" value="retour"></input>
		</form>
	</c:if>
	<c:if test="${empty competence.num}">
		<c:redirect url="/ListCompView" />
	</c:if>
</div>
</body>
</html>