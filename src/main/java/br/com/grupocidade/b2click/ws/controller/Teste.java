package br.com.grupocidade.b2click.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupocidade.b2click.ws.model.Empresa;

@RestController
@RequestMapping("/testes")
public class Teste {

	@GetMapping()
	public List<Empresa> teste() {
		// DADOS MOCADOS
		List<Empresa> list = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			Empresa e = new Empresa();
			e.setId_empresa(i);
			e.setCpfCnpj("" + Math.random() + "" + i);
			e.setNome("Empresa " + i);
			list.add(e);
		}
		return list;
	}

}
