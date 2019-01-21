package com.assiz.basecep.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assiz.basecep.api.entities.Pais;
import com.assiz.basecep.api.repositories.PaisRepository;
import com.assiz.basecep.api.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

	private static final Logger log = LoggerFactory.getLogger(PaisServiceImpl.class);
	
	@Autowired
	private PaisRepository paisRepository;
	
	public Optional<Pais> buscarPorId(Integer id) {
		log.info("Buscando pais por ID: {}", id);
		return Optional.ofNullable(this.paisRepository.findById(id));
	}

	public Optional<Pais> buscarPorSigla(String sigla) {
		log.info("Buscando pais por sigla: {}", sigla);
		return Optional.ofNullable(this.paisRepository.findBySigla(sigla));
	}

}
