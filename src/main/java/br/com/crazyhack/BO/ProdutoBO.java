package br.com.crazyhack.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.crazyhack.DAO.ProdutoDAO;
import br.com.crazyhack.model.ProdutoBean;

public class ProdutoBO {
	
	public List<ProdutoBean> getProdutos() {
		List<ProdutoBean> lista = new ArrayList();
		
		lista = ProdutoDAO.getProdutos();
		
		return lista;
	}
	

}