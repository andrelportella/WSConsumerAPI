package br.com.grupocidade.b2click.ws.service;

import java.text.ParseException;
import java.util.List;

import br.com.grupocidade.b2click.ws.model.Titulo;
import br.com.grupocidade.b2click.ws.model.request.TituloParams;

public interface TituloService {

	/*
	 * Faz a requisição no WS da Redesoft e traz as informações da consulta de
	 * Titulo.
	 * 
	 * @param TitulosParams, Os dados da requisição (dataInicial, dataFinal,
	 * cpfCnpj, documento, codVenda, tipo, situacao, pdv, codEmpresa).
	 * 
	 * @return a Lista de Titulos.
	 * 
	 */
	public List<Titulo> listFilterBy(TituloParams filter) throws ParseException;

	/*
	 * Faz a requisição no WS da Redesoft e salva as informações da consulta de
	 * Titulo no banco de dados.
	 * 
	 * @param TitulosParams, Os dados da requisição (dataInicial, dataFinal,
	 * cpfCnpj, documento, codVenda, tipo, situacao, pdv, codEmpresa).
	 * 
	 * @return a Lista de Titulos salvos.
	 * 
	 * @throws ParseException
	 */
	public List<Titulo> saveInBDTitleFilterBy(TituloParams filter) throws ParseException;
}
