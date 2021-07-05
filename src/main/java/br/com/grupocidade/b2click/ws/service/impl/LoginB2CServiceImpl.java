package br.com.grupocidade.b2click.ws.service.impl;

import javax.transaction.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.grupocidade.b2click.ws.config.Token;
import br.com.grupocidade.b2click.ws.model.request.LoginB2CParams;
import br.com.grupocidade.b2click.ws.model.response.LoginB2CResponse;
import br.com.grupocidade.b2click.ws.service.LoginB2CService;

@Service
@Transactional
public class LoginB2CServiceImpl implements LoginB2CService {

	@Override
	public LoginB2CResponse singIn(LoginB2CParams filter) {
		String url = "https://webservice.b2click.com/erp/redesoft/oauth";
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("grant_type", filter.getGrant_type()).queryParam("client_id", filter.getClient_id())
				.queryParam("username", filter.getUsername()).queryParam("password", filter.getPassword())
				.queryParam("ambiente", filter.getAmbiente());

		HttpEntity<LoginB2CResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null,
				LoginB2CResponse.class);

		if (response.getBody() != null) {
			Token.setToken("Bearer ".concat(response.getBody().getAccess_token()));
		}			

		return response.getBody();
	}

}
