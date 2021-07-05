package br.com.grupocidade.b2click.ws.model.response;

import java.util.List;

import br.com.grupocidade.b2click.ws.model.request.Pagination;
import br.com.grupocidade.b2click.ws.model.request.TituloWS;

public class TituloResponse extends ResponseError {

	private Pagination pagination;

	private List<TituloWS> response;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<TituloWS> getResponse() {
		return response;
	}

	public void setResponse(List<TituloWS> response) {
		this.response = response;
	}

}
