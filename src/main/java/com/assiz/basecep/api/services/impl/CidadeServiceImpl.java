package com.assiz.basecep.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assiz.basecep.api.entities.Cidade;
import com.assiz.basecep.api.repositories.CidadeRepository;
import com.assiz.basecep.api.services.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {

	private static final Logger log = LoggerFactory.getLogger(CidadeServiceImpl.class);
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Optional<Cidade> buscarPorId(Integer id) {
		log.info("Buscando cidade por ID: {}", id);
		return Optional.ofNullable(this.cidadeRepository.findById(id));
	}

	public Optional<Cidade> buscarPorCidadeAndEstadoId(String nome, Integer estadoId) {
		log.info("Buscando cidade por nome: {}", nome);
		return Optional.ofNullable(this.cidadeRepository.findByCidadeAndEstadoId(nome, estadoId));
	
	}

}
