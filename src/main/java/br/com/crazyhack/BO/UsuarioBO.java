package br.com.crazyhack.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.crazyhack.DAO.UsuarioDAO;
import br.com.crazyhack.model.UsuarioBean;

public class UsuarioBO {
	
	public UsuarioBean validaLogin(UsuarioBean usuario, Boolean seguro) {
		
		if(seguro){
			// valida o login seguro
			usuario = UsuarioDAO.validaLoginSeguro( usuario );
		} else {
			// valida o login inseguro
			usuario = UsuarioDAO.validaLoginInseguro( usuario );
		}
		
		return usuario;
	}

	public List<UsuarioBean> getUsuariosPorNome(String nome) {
		List<UsuarioBean> lista = new ArrayList();
		
		lista = UsuarioDAO.listaUsuariosPorNome(nome);
		
		return lista;
	}
}