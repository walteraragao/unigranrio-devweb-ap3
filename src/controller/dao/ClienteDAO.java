package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {

	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	}

	public void insert(Cliente cliente) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO CLIENTE (NOME, EMAIL, CPF, TELEFONE) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getTelefone());
			ps.execute();

			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public void atualiza(Cliente cliente) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL =?, TELEFONE=? WHERE COD_CLIENTE =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setInt(4, cliente.getCodigo());
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public void inativa(Integer codigoCliente) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "UPDATE CLIENTE SET ATIVO='N' WHERE COD_CLIENTE =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoCliente);
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public List<Cliente> buscaTodosOsClientesCadastrados() {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM CLIENTE WHERE ATIVO = 'S'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Cliente> list = new ArrayList<>();
			while (rs.next()) {
				Cliente c = new Cliente(rs.getInt("COD_CLIENTE"), rs.getString("NOME"), rs.getString("EMAIL"),
						rs.getString("CPF"), rs.getString("TELEFONE"));
				list.add(c);
			}
			ps.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public Cliente buscaClientePorCodigo(Integer codigoCliente) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM CLIENTE WHERE COD_CLIENTE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoCliente);
			ResultSet rs = ps.executeQuery();

			Cliente c = null;
			while (rs.next()) {
				c = new Cliente(rs.getInt("COD_CLIENTE"), rs.getString("NOME"), rs.getString("EMAIL"),
						rs.getString("CPF"), rs.getString("TELEFONE"));

			}
			ps.close();
			conn.close();
			return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}
}
