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
	
			<h2>Produtos</h2>
			<a href="index">Sair</a>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Descrição</th>
						<th scope="col">Marca</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${produtos}" var="produto">
					
						<tr>
							<th scope="row"><c:out value="${produto.id}"></c:out></th>
							<td><c:out value="${produto.descricao}"></c:out></td>
							<td><c:out value="${produto.marca}"></c:out></td>
						</tr>
						
					</c:forEach>
					
				</tbody>
			</table>
			
		</div>
	</body>
</html>