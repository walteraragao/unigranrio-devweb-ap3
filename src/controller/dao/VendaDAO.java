package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Motocicleta;
import model.Venda;
import model.enums.StatusVendaEnum;

public class VendaDAO {

	public VendaDAO() {
		// TODO Auto-generated constructor stub
	}
	

	public void insert(Venda venda) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO VENDA (cod_motocicleta, cod_cliente, status, subtotal, desconto, total) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, venda.getMotocicleta().getCodigo());
			ps.setInt(2, venda.getCliente().getCodigo());
			ps.setString(3, StatusVendaEnum.PENDENTE_DE_PAGAMENTO.name());
			ps.setDouble(4, venda.getSubtotal());
			ps.setDouble(5, venda.getDesconto());
			ps.setDouble(6, venda.getTotal());
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}
	
	
	public void atualiza(Venda venda) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "UPDATE VENDA SET cod_motocicleta = ?, cod_cliente = ?, status = ?, subtotal = ?, desconto =?, total = ? WHERE COD_VENDA = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, venda.getMotocicleta().getCodigo());
			ps.setInt(2, venda.getCliente().getCodigo());
			ps.setString(3, venda.getStatusVendaEnum().name());
			ps.setDouble(4, venda.getSubtotal());
			ps.setDouble(5, venda.getDesconto());
			ps.setDouble(6, venda.getTotal());
			ps.setInt(7, venda.getCodigo());
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	
	public List<Venda> buscaTodasAsVendas() {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM VENDA";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<Venda> vendas = new ArrayList<>();
			
			while(rs.next()) {
				Venda v = new Venda();
				v.setCliente(new ClienteDAO().buscaClientePorCodigo(rs.getInt("COD_CLIENTE")));
				v.setMotocicleta(new MotocicletaDAO().buscaPorCodigo(rs.getInt("COD_MOTOCICLETA")));
				v.setDataVenda(rs.getTimestamp("DATA_VENDA"));
				v.setDesconto(rs.getDouble("DESCONTO"));
				v.setCodigo(rs.getInt("COD_VENDA"));
				v.setStatusVendaEnum(StatusVendaEnum.buscaEnum(rs.getString("STATUS")));
				v.setSubtotal(rs.getDouble("SUBTOTAL"));
				v.setTotal(rs.getDouble("TOTAL"));
				vendas.add(v);
			}
			
			ps.close();
			conn.close();
			
			return vendas;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}
	
	
	public List<Venda> buscaVendasPorCliente(Integer codigo) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM VENDA WHERE COD_CLIENTE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			List<Venda> vendas = new ArrayList<>();
			
			while(rs.next()) {
				Venda v = new Venda();
				v.setCliente(new ClienteDAO().buscaClientePorCodigo(rs.getInt("COD_CLIENTE")));
				v.setMotocicleta(new MotocicletaDAO().buscaPorCodigo(rs.getInt("COD_MOTOCICLETA")));
				v.setDataVenda(rs.getTimestamp("DATA_VENDA"));
				v.setDesconto(rs.getDouble("DESCONTO"));
				v.setCodigo(rs.getInt("COD_VENDA"));
				v.setStatusVendaEnum(StatusVendaEnum.buscaEnum(rs.getString("STATUS")));
				v.setSubtotal(rs.getDouble("SUBTOTAL"));
				v.setTotal(rs.getDouble("TOTAL"));
				vendas.add(v);
			}
			
			ps.close();
			conn.close();
			
			return vendas;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	
	public List<Venda> buscaVendasPorMotocicleta(Integer codigo) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM VENDA WHERE COD_MOTOCICLETA = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			List<Venda> vendas = new ArrayList<>();
			
			while(rs.next()) {
				Venda v = new Venda();
				v.setCliente(new ClienteDAO().buscaClientePorCodigo(rs.getInt("COD_CLIENTE")));
				v.setMotocicleta(new MotocicletaDAO().buscaPorCodigo(rs.getInt("COD_MOTOCICLETA")));
				v.setDataVenda(rs.getTimestamp("DATA_VENDA"));
				v.setDesconto(rs.getDouble("DESCONTO"));
				v.setCodigo(rs.getInt("COD_VENDA"));
				v.setStatusVendaEnum(StatusVendaEnum.buscaEnum(rs.getString("STATUS")));
				v.setSubtotal(rs.getDouble("SUBTOTAL"));
				v.setTotal(rs.getDouble("TOTAL"));
				vendas.add(v);
			}
			
			ps.close();
			conn.close();
			
			return vendas;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	
}
