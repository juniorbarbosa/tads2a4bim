package br.univel.cadastro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoH2Impl implements ClienteDAO {

	private static Connection con;

	private Connection getConnection() throws SQLException {

		synchronized (con) {
			if (con == null) {
				abrirConexao();
			}
			return con;
		}
	}

	private void abrirConexao() throws SQLException {
		String url = "jdbc:h2:./aulah2";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);
	}

	public void inserir(Cliente c) {
		String sql = "INSERT INTO PESSOA (ID, NOME) VALUES (?, ?)";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void fecharConexao() throws SQLException {
		con.close();
	}

	public void atualizar(Cliente c) {
		String sql = "UPDATE CLIENTE SET ...... WHERE ID=";
	}

	public void excluir(Cliente c) {

	}

	public Cliente buscar(int id) {

		return null;
	}

	public Cliente buscarPorExemplo(Cliente c) {

		return null;
	}

	public List<Cliente> listar() {

		return null;
	}
}