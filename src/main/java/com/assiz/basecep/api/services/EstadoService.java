package com.assiz.basecep.api.services;

import java.util.Optional;

import com.assiz.basecep.api.entities.Estado;

public interface EstadoService {

	/**
	 * Busca e retorna um estado pelo ID.
	 * 
	 * @param id
	 * @return Optional<Estado>
	 */
	Optional<Estado> buscarPorId(Integer id);

	/**
	 * Busca e retorna um estado pela sigla.
	 * 
	 * @param sigla
	 * @return Optional<Estado>
	 */
	Optional<Estado> buscarPorSigla(String sigla);

}
