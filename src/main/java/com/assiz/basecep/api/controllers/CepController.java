package com.assiz.basecep.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assiz.basecep.api.dtos.CepDto;
import com.assiz.basecep.api.entities.Cep;
import com.assiz.basecep.api.responses.Response;
import com.assiz.basecep.api.services.CepService;

@RestController
@RequestMapping("/ceps")
@CrossOrigin(origins = "*")
public class CepController {

	private static final Logger log = LoggerFactory.getLogger(CepController.class);
	
	@Autowired
	private CepService cepService;
	
	@GetMapping(value = "/{cepId}")
	public ResponseEntity<Response<CepDto>> listarPorCepId(
			@PathVariable("cepId") String cepId) {
		log.info("Buscando cep {}", cepId);
		Response<CepDto> response = new Response<CepDto>();
		Optional<Cep> cep = cepService.buscarPorCep(cepId);
		
		if (!cep.isPresent()) {
			log.info("Cep {} não encontrado", cepId);
			response.getErrors().add("Cep " + cepId + " não encontrado ");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterCepDto(cep.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna um DTO com os dados de um cep.
	 * 
	 * @param cep
	 * @return CepDto
	 */
	private CepDto converterCepDto(Cep cep) {
		CepDto cepDto = new CepDto();
		cepDto.setCep(cep.getCep());
		cepDto.setLogradouro(cep.getLogradouro());
		cepDto.setComplemento(cep.getComplemento());
		cepDto.setBairro(cep.getBairro());
		
		return cepDto;
	}
	
}
