package br.com.trilhajee.bean;

import java.util.List;

import br.com.trilhajee.model.Lancamento;

public interface LancamentoBean {
	
	List<Lancamento> obterListaDeLancamentos(Lancamento filtro) throws Exception;

}
