package com.assiz.basecep.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assiz.basecep.api.entities.Cep;
import com.assiz.basecep.api.repositories.CepRepository;
import com.assiz.basecep.api.services.CepService;

@Service
public class CepServiceImpl implements CepService {

	private static final Logger log = LoggerFactory.getLogger(CepServiceImpl.class);
	
	@Autowired
	private CepRepository cepRepository;
	
	public Optional<Cep> buscarPorCep(String cep) {
		log.info("Buscando CEP {}", cep);
		return Optional.ofNullable(this.cepRepository.findByCep(cep));
	}

}
