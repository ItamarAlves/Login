package br.com.crazyhack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crazyhack.factory.ConnectionFactory;
import br.com.crazyhack.model.UsuarioBean;

public class UsuarioDAO {

	private static Connection conn;

	private UsuarioDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<UsuarioBean> listaUsuariosPorNome(String nome) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			new UsuarioDAO();

			String sql = "SELECT * from usuario where nome like '%" + nome + "%'";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			List<UsuarioBean> lista = new ArrayList();

			while(rs.next()) {
				UsuarioBean usuario = new UsuarioBean();

				usuario.setId(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));

				lista.add(usuario);
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

	public static UsuarioBean validaLoginSeguro(UsuarioBean usuario) {
		new UsuarioDAO(); // chama o método construtor acima, que faz a conexão com o banco de dados

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * \nfrom usuario \nwhere login=? and senha=?"; // declaração da cláusula sql
			System.out.println(sql); // imprime no console

			ps = conn.prepareStatement(sql); // Prepara a instrução sql
			ps.setString(1, usuario.getLogin());  // Passando valor para o primeiro ?
			ps.setString(2, usuario.getSenha()); // Passando valor para o segundo ?

			rs = ps.executeQuery(); // Executa a instrução sql no banco e retorna o resultado para o objeto rs

			rs.next(); // posiciona o cursor para a primeira linha

			usuario.setId( rs.getInt("idUsuario") );  // Recupera o id do usuario
			usuario.setLogin(rs.getString("login") ); // Recupera o login do usuário
			usuario.setNome( rs.getString("nome") );  // Recupera o nome do usuário

		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		} finally {
			try {
				rs.close(); // Encerra a conexão
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario; // retorna o usuário encontrado
	}


	public static UsuarioBean validaLoginInseguro(UsuarioBean usuario) {
		new UsuarioDAO();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = "select * from usuario where login = '" + usuario.getLogin() + "' and senha = '" + usuario.getSenha() + "'";
			System.out.println(sql);

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			rs.next();	

			usuario.setId( rs.getInt("idUsuario") );
			usuario.setLogin(rs.getString("login") );
			usuario.setNome( rs.getString("nome") );

		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		} finally {
			try {
				rs.close(); // Encerra a conexão
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario; // retorna o usuário encontrado
	}
}