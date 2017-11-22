package br.com.trilhajee.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class ConexaoTest {
	
	@Test
	public void TestAbrirConexaoComBancoDeDados() throws Exception{
		
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		
		try {
			con = ConexaoJDBC.getConexaoJDBC();

			st = con.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS lancamentoteste "
					+ "(id IDENTITY PRIMARY KEY, "
					+ "nome VARCHAR(50), "
					+ "tipolancamento VARCHAR(50))";
			
			st.execute(sql);
	
			st.execute("INSERT INTO lancamentoteste (nome, tipolancamento) values ('JOAO DA SILVA', 'PADRONIZADO')");
            
			rs = st.executeQuery("SELECT * FROM lancamentoteste");
			
			Assert.assertTrue(rs.next());
			Assert.assertEquals("JOAO DA SILVA", rs.getString("nome"));
			Assert.assertEquals("PADRONIZADO", rs.getString("tipolancamento"));
			
			st.execute("DELETE FROM lancamentoteste WHERE nome = 'JOAO DA SILVA'");
			
			rs = st.executeQuery("SELECT * FROM LANCAMENTOTESTE");
			
			Assert.assertFalse(rs.next());
			
		} catch (

		Exception e) {
			con.rollback();
			throw e;

		} finally {
			con.close();
		}
	}

}
