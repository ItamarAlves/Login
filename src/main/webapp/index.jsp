<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
		
		<jsp:include page="_headerDefault.jsp" />
		
	</head>

	<body>
		<h2>Bem vindo ${usuario}!</h2>
	</body>
	<a href="index">Sair</a>
</html>