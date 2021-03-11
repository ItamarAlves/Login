package br.com.crazyhack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.crazyhack.factory.ConnectionFactory;
import br.com.crazyhack.model.UsuarioBean;

public class UsuarioDao {
	
	private static Connection conn;

	private UsuarioDao() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static UsuarioBean validaLoginSeguro(UsuarioBean usuario) throws SQLException {
		new UsuarioDao(); // chama o método construtor acima, que faz a conexão com o banco de dados

		String sql = "select * \nfrom usuario \nwhere login=? and senha=?"; // declaração da cláusula sql
		System.out.println(sql); // imprime no console

		PreparedStatement ps = conn.prepareStatement(sql); // Prepara a instrução sql
		ps.setString(1, usuario.getLogin());  // Passando valor para o primeiro ?
		ps.setString(2, usuario.getSenha()); // Passando valor para o segundo ?

		ResultSet rs = ps.executeQuery(); // Executa a instrução sql no banco e retorna o resultado para o objeto rs

		rs.next(); // posiciona o cursor para a primeira linha

		usuario.setId( rs.getInt("idUsuario") );  // Recupera o id do usuario
		usuario.setLogin(rs.getString("login") ); // Recupera o login do usuário
		usuario.setNome( rs.getString("nome") );  // Recupera o nome do usuário

		// Encerra a conexão
		rs.close();
		ps.close();
		conn.close();

		return usuario; // retorna o usuário encontrado
	}


	public static UsuarioBean validaLoginInseguro(UsuarioBean usuario) throws SQLException {
		new UsuarioDao();

		String sql = "select * from usuario where login = '" + usuario.getLogin() + "' and senha = '" + usuario.getSenha() + "'";
		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();	

		usuario.setId( rs.getInt("idUsuario") );
		usuario.setLogin(rs.getString("login") );
		usuario.setNome( rs.getString("nome") );

		rs.close();
		ps.close();
		conn.close();

		return usuario;
	}
}