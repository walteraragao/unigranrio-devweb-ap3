package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Motocicleta;
import model.enums.StatusMotocicletaEnum;

public class MotocicletaDAO {

	public MotocicletaDAO() {
		// TODO Auto-generated constructor stub
	}

	public void insert(Motocicleta moto) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO MOTOCICLETA (nome_dono, ano, modelo, marca, preco, status) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, moto.getNomeDono());
			ps.setInt(2, moto.getAno());
			ps.setString(3, moto.getModelo());
			ps.setString(4, moto.getMarca());
			ps.setDouble(5, moto.getPreco());
			ps.setString(6, moto.getStatus().name());
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public void atualiza(Motocicleta moto) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "UPDATE MOTOCICLETA SET nome_dono = ?, ano = ?, modelo = ?, marca = ?, preco = ?, status = ? WHERE codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, moto.getNomeDono());
			ps.setInt(2, moto.getAno());
			ps.setString(3, moto.getModelo());
			ps.setString(4, moto.getMarca());
			ps.setDouble(5, moto.getPreco());
			ps.setString(6, moto.getStatus().name());
			ps.setInt(7, moto.getCodigo());
			ps.execute();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}
	}

	public Motocicleta buscaPorCodigo(Integer codigo) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM MOTOCICLETA WHERE COD_MOTOCICLETA = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();

			Motocicleta moto = null;
			while (rs.next()) {
				moto = new Motocicleta(
						rs.getInt("COD_MOTOCICLETA"), 
						rs.getString("NOME_DONO"), 
						rs.getInt("ANO"), 
						rs.getString("MODELO"), 
						rs.getString("MARCA"), 
						rs.getDouble("PRECO"), 
						StatusMotocicletaEnum.buscaEnum(rs.getString("STATUS"))
						);
			}
			ps.close();
			conn.close();
			return moto;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro ao se conectar com o Banco de dados.");
		}

	}

	public List<Motocicleta> buscaTodos() {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM MOTOCICLETA WHERE STATUS <> ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, StatusMotocicletaEnum.INATIVA.name());
			ResultSet rs = ps.executeQuery();
			List<Motocicleta> list = new ArrayList<>();
			
			while (rs.next()) {
				Motocicleta moto = new Motocicleta(
						rs.getInt("COD_MOTOCICLETA"), 
						rs.getString("NOME_DONO"), 
						rs.getInt("ANO"), 
						rs.getString("MODELO"), 
						rs.getString("MARCA"), 
						rs.getDouble("PRECO"), 
						StatusMotocicletaEnum.buscaEnum(rs.getString("STATUS"))
						);
				list.add(moto);
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
	
	
	public List<Motocicleta> buscaTodosPorStatus(StatusMotocicletaEnum status) {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "SELECT * FROM MOTOCICLETA WHERE STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status.name());
			ResultSet rs = ps.executeQuery();
			List<Motocicleta> list = new ArrayList<>();
			
			while (rs.next()) {
				Motocicleta moto = new Motocicleta(
						rs.getInt("COD_MOTOCICLETA"), 
						rs.getString("NOME_DONO"), 
						rs.getInt("ANO"), 
						rs.getString("MODELO"), 
						rs.getString("MARCA"), 
						rs.getDouble("PRECO"), 
						StatusMotocicletaEnum.buscaEnum(rs.getString("STATUS"))
						);
				list.add(moto);
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
}
