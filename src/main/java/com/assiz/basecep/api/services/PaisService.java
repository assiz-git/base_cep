package com.assiz.basecep.api.services;

import java.util.Optional;

import com.assiz.basecep.api.entities.Pais;

public interface PaisService {

	/**
	 * Busca e retorna um pais pelo ID.
	 * 
	 * @param id
	 * @return Optional<Pais>
	 */
	Optional<Pais> buscarPorId(Integer id);

	/**
	 * Busca e retorna um pais pela sigla.
	 * 
	 * @param sigla
	 * @return Optional<Pais>
	 */
	Optional<Pais> buscarPorSigla(String sigla);

}
