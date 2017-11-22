package br.com.trilhajee.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.trilhajee.dao.LancamentoDao;
import br.com.trilhajee.model.Lancamento;

public class LancamentoBeanImpl implements LancamentoBean{

	public List<Lancamento> obterListaDeLancamentos(Lancamento filtro) throws Exception {
		// TODO Auto-generated method stub
		
		LancamentoDao dao = new LancamentoDao();
		List<Lancamento> retorno = dao.getListLancamento(filtro);
		
		
		
		return retorno;
	}

	
}
