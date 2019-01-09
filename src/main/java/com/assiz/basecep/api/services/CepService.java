package com.assiz.basecep.api.services;

import java.util.Optional;

import com.assiz.basecep.api.entities.Cep;

public interface CepService {

	/**
	 * Busca e retorna um CEP pelo número.
	 * 
	 * @param cep
	 * @return Optional<Cep>
	 */
	Optional<Cep> buscarPorCep(String cep);

}
