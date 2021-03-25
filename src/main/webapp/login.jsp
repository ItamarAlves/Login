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
		
			<h2 class="row d-flex justify-content-center mb-5">Crazy Hack</h2>
			
			<div id="formulario">
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
			<div id="conteudo">
				<h2>Você consegue?</h2>
				<p>Tente acessar as camadas e treine seus conceitos sobre segurança.</p>
				<script data-ad-client="ca-pub-8434945871546401" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
			</div>
		</div>
		${erro}
	</body>
	
</html>