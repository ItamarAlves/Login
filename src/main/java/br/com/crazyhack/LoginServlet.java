package br.com.crazyhack;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crazyhack.BO.ProdutoBO;
import br.com.crazyhack.BO.UsuarioBO;
import br.com.crazyhack.model.ProdutoBean;
import br.com.crazyhack.model.UsuarioBean;

@WebServlet("/index")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pl = "\n";
	private HttpServletRequest request;
	private HttpServletResponse response;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}
	
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		String acao = request.getParameter("acao");

		if (acao == null) acao = "criaFormulario";
		
		if (acao.equals("criaFormulario")) {
			
			criarLoginForm(request, response);

		} else if (acao.equals("validaLogin")){
			
			validaLogin(request, response);
			
		} else if (acao.equals("listarUsuarios")){
			
			listaUsuarios(request, response);
			
		} else if (acao.equals("listarProdutos")) {
			
			listaProdutos(request, response);
			
		}
	}
	
	private void listaProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProdutoBO bo = new ProdutoBO();
		
		List<ProdutoBean> lista = bo.getProdutos();
		
		request.setAttribute("produtos", lista);
		sendRedirect("produtos.jsp", "Produtos");
	}

	private void listaUsuarios (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = request.getParameter("nome");
		
		UsuarioBO bo = new UsuarioBO();
		List<UsuarioBean> lista = bo.getUsuariosPorNome(nome);
		
		request.setAttribute("usuarios", lista);
		sendRedirect("index.jsp", "Início");
	}
	
	private void validaLogin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		UsuarioBean usuario = new UsuarioBean();

		usuario.setLogin( request.getParameter("login") );
		usuario.setSenha( request.getParameter("senha") );
		
		Boolean seguranca = false;
		
		if (request.getParameter("checkS") != null) seguranca = true;
		
		UsuarioBO bo = new UsuarioBO();
		
		usuario = bo.validaLogin(usuario, seguranca);
		
		if ( usuario != null ) {
			// iniciando sessão do usuário
			
			request.setAttribute("usuario", usuario.getNome());
			sendRedirect("index.jsp", "Início");

		} else {
			request.setAttribute("erro", "<script language=\"JavaScript\">alert(\"Usuário/senha invalido!\");</script>");
			sendRedirect("login.jsp", "Login");
		}

	}

	private void criarLoginForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		sendRedirect("login.jsp", "Login");
	}
	
	private void sendRedirect(String destino, String titulo) throws ServletException, IOException {
		request.setAttribute("pageName", titulo);
		RequestDispatcher view = request.getRequestDispatcher(destino);
		view.forward(request, response);
	}

}