package br.com.grupocidade.b2click.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupocidade.b2click.ws.model.request.LoginB2CParams;
import br.com.grupocidade.b2click.ws.model.response.LoginB2CResponse;
import br.com.grupocidade.b2click.ws.service.LoginB2CService;

@RestController
@RequestMapping("/loginB2Click")
public class LoginB2CController {

	@Autowired
	LoginB2CService loginB2CService;

	public LoginB2CController(LoginB2CService lc) {
		this.loginB2CService = lc;
	}

	@PostMapping()
	public ResponseEntity<?> efetuarLogin(@ModelAttribute LoginB2CParams filter) {
		return new ResponseEntity<LoginB2CResponse>(this.loginB2CService.singIn(filter), HttpStatus.OK);
	}

}
