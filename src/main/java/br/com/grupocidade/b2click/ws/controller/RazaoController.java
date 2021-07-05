package br.com.grupocidade.b2click.ws.controller;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.grupocidade.b2click.ws.error.ResourceNotFoundException;
import br.com.grupocidade.b2click.ws.model.request.RazaoParams;
import br.com.grupocidade.b2click.ws.service.RazaoService;


@RestController
@RequestMapping("/razao")
public class RazaoController {
	
	@Autowired
	RazaoService razaoService;

	public RazaoController(RazaoService rs) {
		this.razaoService = rs;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping()
	public ResponseEntity<?> listFilterBy(@ModelAttribute RazaoParams filter) {
		try {
			return new ResponseEntity<List>(this.razaoService.listFilterBy(filter), HttpStatus.OK);
		} catch (ParseException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"Error, Data de vencimento invalida \n" + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Nenhum registro encontrado!");
		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/importar")
	public ResponseEntity<?> saveInBDTitleFilterBy(@ModelAttribute RazaoParams filter) {
		try {
			return new ResponseEntity<List>(this.razaoService.saveInBDRazaoFilterBy(filter), HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"Error, algum registro está com a data invalida \n" + e.getMessage());
		}
	}	

}
