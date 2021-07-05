package br.com.grupocidade.b2click.ws.service;

import br.com.grupocidade.b2click.ws.model.request.LoginB2CParams;
import br.com.grupocidade.b2click.ws.model.response.LoginB2CResponse;

public interface LoginB2CService {

	
	/*
	 * Faz login no Web Service da Redesoft.
	 * 
	 * @param LoginB2C, Os dados do Login.
	 * 
	 * @return O token.	
	 * 
	 */
	public LoginB2CResponse singIn(LoginB2CParams filter);
}
