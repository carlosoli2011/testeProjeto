package br.com.trilhajee.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.trilhajee.model.Lancamento;

public class TestaConexaoJDBC {

	public static void main(String[] args) throws Exception {

		Connection con = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			System.out.println(ConexaoJDBC.statusConection());
			con = ConexaoJDBC.getConexaoJDBC();
			System.out.println(ConexaoJDBC.statusConection());

			st = con.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS lancamento "
					+ "(id IDENTITY PRIMARY KEY, "
					+ "nome VARCHAR(50), "
					+ "tipolancamento VARCHAR(50))";
			
			st.execute(sql);

			
			

		} catch (

		Exception e) {
			con.rollback();
			throw e;

		} finally {
			// ConexaoJDBC.close(con, ps, rs);
			con.close();
			System.out.println(ConexaoJDBC.statusConection());
		}
	}
}
