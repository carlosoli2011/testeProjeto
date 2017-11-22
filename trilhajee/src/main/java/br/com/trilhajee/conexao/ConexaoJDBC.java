package br.com.trilhajee.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoJDBC {

	public static String status = "Não conectou...";

	public ConexaoJDBC() {

	}

	// Método de Conexão//

	public static Connection getConexaoJDBC() throws SQLException, ClassNotFoundException{

		
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:hsqldb:file:/home/carlos/Documentos/Servidor/web/trilhajee/bancoDados", "sa", "");

			if (con != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}
			
			return con;

		

	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Connection connection = null; // atributo do tipo Connection
	 * 
	 * try {
	 * 
	 * // Carregando o JDBC Driver padrão Class.forName("org.hsqldb.jdbcDriver");
	 * 
	 * String driverName = "com.mysql.jdbc.Driver";
	 * 
	 * Class.forName(driverName);
	 * 
	 * // Configurando a nossa conexão com um banco de dados//
	 * 
	 * //String serverName = "localhost"; // caminho do servidor do BD
	 * 
	 * //String mydatabase = "projetotrilha"; // nome do seu banco de dados
	 * 
	 * String url =
	 * "jdbc:hsqldb:file:/home/carlos/Documentos/Servidor/web/trilhajee/bancoDados";
	 * 
	 * String username = "SA"; // nome de um usuário de seu BD
	 * 
	 * String password = ""; // sua senha de acesso
	 * 
	 * connection = DriverManager.getConnection(url, username, password);
	 * 
	 * // Testa sua conexão//
	 * 
	 * if (connection != null) {
	 * 
	 * status = ("STATUS--->Conectado com sucesso!");
	 * 
	 * } else {
	 * 
	 * status = ("STATUS--->Não foi possivel realizar conexão");
	 * 
	 * }
	 * 
	 * return connection;
	 * 
	 * } catch (ClassNotFoundException e) { // Driver não encontrado
	 * 
	 * System.out.println("O driver expecificado nao foi encontrado.");
	 * 
	 * return null;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * // Não conseguindo se conectar ao banco
	 * 
	 * System.out.println("Nao foi possivel conectar ao Banco de Dados.");
	 * 
	 * return null;
	 * 
	 * }
	 */

	// Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}
	
	
	
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) throws Exception {
        
		boolean fechada = false;
		
		if (rs != null) {
            rs.close();
            fechada = true;
        } else {
        	fechada = false;
        }

        if (ps != null) {
            ps.close();
            fechada = true;
        } else {
        	fechada = false;
        }

        if (con != null) {
            con.close();
            fechada = true;
        } else {
        	fechada = false;
        }
        
        if(fechada) {
        	status = ("STATUS--->Conexao fechada com sucesso!");
        } else {
        	status = ("STATUS--->Conexao ainda esta aberta");
        }
        
    }
	
	

/*	// Método que fecha sua conexão//

	public static String fecharConexao() {

		String teste = "Conexao fechada";
		
		try {

			ConexaoJDBC.getConexaoJDBC().close();
			
			

			return teste;

		} catch (SQLException e) {

			return teste + e;

		}

	}*/

	// Método que reinicia sua conexão//



}
