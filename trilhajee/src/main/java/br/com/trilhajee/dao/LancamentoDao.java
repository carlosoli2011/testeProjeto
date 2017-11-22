package br.com.trilhajee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.trilhajee.conexao.ConexaoJDBC;
import br.com.trilhajee.model.Lancamento;

@XmlRootElement
public class LancamentoDao {
	
	private List<Lancamento> listLancamento;

    public LancamentoDao() {
    }

    public LancamentoDao(List<Lancamento> listLancamento) {
        this.listLancamento = listLancamento;
    }

    public List<Lancamento> getListLancamento(Lancamento lancamento) throws Exception {
    	
    	Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		
		
		try {
			con = ConexaoJDBC.getConexaoJDBC();
			st = con.createStatement();
			
			st.executeQuery("Insert into lancamento (nome) values ('Maria')");
			
			String sql = "SELECT * FROM LANCAMENTO";
			rs = st.executeQuery(sql);
			
			Lancamento retorno = new Lancamento();
			
			while(rs.next()) {
				retorno.setNome(rs.getString("nome"));
				listLancamento.add(retorno);
			}
			
		} catch (Exception e) {
			con.rollback();
			throw e;
		}
		
        return listLancamento;
    }

    public void setListLancamento(List<Lancamento> listLancamento) {
        this.listLancamento = listLancamento;
}

}
