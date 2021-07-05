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
import br.com.grupocidade.b2click.ws.model.request.TituloParams;
import br.com.grupocidade.b2click.ws.service.TituloService;

@RestController
@RequestMapping("/titulo")
public class TituloController {

	@Autowired
	TituloService tituloService;

	public TituloController(TituloService ts) {
		this.tituloService = ts;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping()
	public ResponseEntity<?> listFilterBy(@ModelAttribute TituloParams filter) {
		try {
			return new ResponseEntity<List>(this.tituloService.listFilterBy(filter), HttpStatus.OK);
		} catch (ParseException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"Error, Data de vencimento invalida \n" + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Nenhum registro encontrado!");
		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/importar")
	public ResponseEntity<?> saveInBDTitleFilterBy(@ModelAttribute TituloParams filter) {
		try {
			return new ResponseEntity<List>(this.tituloService.saveInBDTitleFilterBy(filter), HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"Error, algum registro está com a data invalida \n" + e.getMessage());
		}
	}

}
