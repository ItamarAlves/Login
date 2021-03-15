package br.com.crazyhack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crazyhack.factory.ConnectionFactory;
import br.com.crazyhack.model.ProdutoBean;
import br.com.crazyhack.model.UsuarioBean;

public class ProdutoDAO {
	private static Connection conn;

	public ProdutoDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<ProdutoBean> getProdutos() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			new ProdutoDAO();

			String sql = "SELECT * from produto";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			List<ProdutoBean> lista = new ArrayList();

			while(rs.next()) {
				ProdutoBean produto = new ProdutoBean();

				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));

				lista.add(produto);
			}

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}