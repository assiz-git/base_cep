package com.assiz.basecep.api.services;

import java.util.Optional;

import com.assiz.basecep.api.entities.Cidade;

public interface CidadeService {

	/**
	 * Busca e retorna uma cidade pelo ID.
	 * 
	 * @param id
	 * @return Optional<Cidade>
	 */
	Optional<Cidade> buscarPorId(Integer id);

	/**
	 * Busca e retorna uma cidade pelo nome.
	 * 
	 * @param nome
	 * @return Optional<Cidade>
	 */
	Optional<Cidade> buscarPorCidadeAndEstadoId(String nome, Integer estadoId);

}
