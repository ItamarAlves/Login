<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
		
		<jsp:include page="_headerDefault.jsp" />
		
	</head>
	
	<body>
		
		<div class="container">
		
			<h2>Crazy Hack</h2>
			
			<form method="post" action="index">
				<fieldset>
					<legend>Login</legend>
					
					<input type="hidden" name="acao" value="validaLogin">
					
					<div class="form-group row">
						<div class="col-lg-5">
							<label for="login">Usuário:</label>
							<input type="text" name="login" id="login" placeholder="Informe seu login" maxlength="100" required class="form-control">
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-lg-5">
							<label for="senha">Senha:</label>
							<input type="password" name="senha" id="senha" placeholder="Informe sua senha" maxlength="100" required class="form-control">
						</div>
					</div>

					<input type="submit" value="Entrar" name="btnSalvar" class="btn btn-success">

					<span class="ml-4">
						<input type="checkbox" value="S" name="checkS" class="form-check-input mt-2" id="S" checked>
						<label class="form-check-label" for="S">Login Seguro</label>
					</span>
				</fieldset>
			</form>
		</div>
		${erro}
	</body>
	
</html>