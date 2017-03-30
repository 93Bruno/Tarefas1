package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cardapio;

public class CardapioDAO {
	public int criar(Cardapio cardapio) {
		String sqlInsert = "INSERT INTO cardapio(idProduto ,nomeProduto, descProduto, valorProduto, dispProduto) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, cardapio.getIdProduto());
			stm.setString(2, cardapio.getNomeProduto());
			stm.setString(3, cardapio.getDispProduto());
			stm.setDouble(4, cardapio.getValorProduto());
         stm.setString(5, cardapio.getDispProduto());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cardapio.setIdProduto(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardapio.getIdProduto();
	}

	public void atualizar(Cardapio cardapio) {
		String sqlUpdate = "UPDATE cardapio SET nomeProduto=?, descProduto=?, valorProduto=?, dispProduto=? WHERE idProduto=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cardapio.getNomeProduto());
			stm.setString(2, cardapio.getDescProduto());
			stm.setDouble(3, cardapio.getValorProduto());
         stm.setString(4, cardapio.getDispProduto());
			stm.setInt(5, cardapio.getIdProduto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int idProduto) {
		String sqlDelete = "DELETE FROM cardapio WHERE idproduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idProduto);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cardapio carregar(int idProduto) {
		Cardapio cardapio = new Cardapio();
		cardapio.setIdProduto(idProduto);
		String sqlSelect = "SELECT nomeProduto, descProduto, valorProduto, dispProduto FROM cardapio WHERE cardapio.idProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cardapio.getIdProduto());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cardapio.setNomeProduto(rs.getString("nomeProduto"));
					cardapio.setDescProduto(rs.getString("descProduto"));
					cardapio.setValorProduto(rs.getDouble("valorProduto"));
               cardapio.setDispProduto(rs.getString("dispProduto"));
				} else {
					cardapio.setIdProduto(-1);
					cardapio.setNomeProduto(null);
					cardapio.setValorProduto(-1);
					cardapio.setDispProduto(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cardapio;
	}

}
