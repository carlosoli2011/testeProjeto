package br.com.trilhajee.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.trilhajee.bean.LancamentoBean;
import br.com.trilhajee.dao.LancamentoDao;
import br.com.trilhajee.model.Lancamento;

@Path("/obterLancamentos")
public class LancamentoWebService {
	
	@Inject
	private LancamentoBean lancamentoBean;
	
	
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response consultarLancamento(final Lancamento filtro) throws Exception {
    	
    	List<Lancamento> ret = lancamentoBean.obterListaDeLancamentos(null);
    	return Response.ok(new LancamentoDao(ret)).build();
	}

}
