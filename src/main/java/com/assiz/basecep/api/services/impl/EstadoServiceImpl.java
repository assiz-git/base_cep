package com.assiz.basecep.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assiz.basecep.api.entities.Estado;
import com.assiz.basecep.api.repositories.EstadoRepository;
import com.assiz.basecep.api.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	private static final Logger log = LoggerFactory.getLogger(EstadoServiceImpl.class);
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Optional<Estado> buscarPorId(Integer id) {
		log.info("Buscando estado por ID: {}", id);
		return Optional.ofNullable(this.estadoRepository.findById(id));
	}

	public Optional<Estado> buscarPorSigla(String sigla) {
		log.info("Buscando estado por sigla: {}", sigla);
		return Optional.ofNullable(this.estadoRepository.findBySigla(sigla));
	}

}
