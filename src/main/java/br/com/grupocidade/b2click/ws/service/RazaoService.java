package br.com.grupocidade.b2click.ws.service;

import java.text.ParseException;
import java.util.List;

import br.com.grupocidade.b2click.ws.model.Razao;
import br.com.grupocidade.b2click.ws.model.request.RazaoParams;
public interface RazaoService {

	/*
	 * Faz a requisição no WS da Redesoft e traz as informações do razão.
	 * 
	 * @param RazaoParams, Os dados da requisição (dataInicial, dataFinal,
	 * codEmpresa).
	 * 
	 * @return a Lista do razão.
	 * 
	 */
	
	public List<Razao> listFilterBy(RazaoParams filter) throws ParseException;
	
	/*
	 * Faz a requisição no WS da Redesoft e salva as informações da consulta de
	 * Razão no banco de dados.
	 * 
	 * @param TitulosParams, Os dados da requisição ((dataInicial, dataFinal,
	 * codEmpresa).
	 * 
	 * @return a Lista de Razão salvos.
	 * 
	 * @throws ParseException
	 */	
	
	public List<Razao> saveInBDRazaoFilterBy(RazaoParams filter) throws ParseException;
}
