package br.com.grupocidade.b2click.ws.model.response;

import java.util.List;

import br.com.grupocidade.b2click.ws.model.request.Pagination;
import br.com.grupocidade.b2click.ws.model.request.RazaoWS;

public class RazaoResponse extends ResponseError {

	private Pagination pagination;

	private List<RazaoWS> response;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<RazaoWS> getResponse() {
		return response;
	}

	public void setResponse(List<RazaoWS> response) {
		this.response = response;
	}

}
