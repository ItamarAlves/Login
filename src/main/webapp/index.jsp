<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.crazyhack.*"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>

<jsp:include page="_headerDefault.jsp" />

</head>

<body>
	
	<div class="container">
	
		<h2>Bem vindo ${usuario}!</h2>
		<a href="index">Sair</a>
		
		<form class="form-inline" method="get" action="index">
			<input type="hidden" name="acao" value="listarUsuarios">
			<div class="form-group mb-2">
    			<label for="nome" class="sr-only">Nome:</label>
    			<input type="text" class="form-control" id="nome" name="nome" placeholder="Pesquisar Nome de usuário" maxlength="100">
  			</div>
			<button type="submit" class="btn btn-primary mx-sm-3 mb-2">Pesquisar</button>
		
		</form>
	
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Login</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${usuarios}" var="usuario">
				
					<tr>
						<th scope="row"><c:out value="${usuario.id}"></c:out></th>
						<td><c:out value="${usuario.nome}"></c:out></td>
						<td><c:out value="${usuario.login}"></c:out></td>
					</tr>
					
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>