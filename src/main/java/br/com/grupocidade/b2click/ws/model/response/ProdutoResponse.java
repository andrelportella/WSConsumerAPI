package br.com.grupocidade.b2click.ws.model.response;

import br.com.grupocidade.b2click.ws.model.request.ProdutoWS;

public class ProdutoResponse extends ResponseError {

	ProdutoWS response[];

	public ProdutoWS[] getResponse() {
		return response;
	}

	public void setResponse(ProdutoWS[] response) {
		this.response = response;
	}
	
}
