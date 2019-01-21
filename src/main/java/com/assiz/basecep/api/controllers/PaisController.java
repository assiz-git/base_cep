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

import com.assiz.basecep.api.dtos.PaisDto;
import com.assiz.basecep.api.entities.Pais;
import com.assiz.basecep.api.repositories.PaisRepository;
import com.assiz.basecep.api.responses.Response;
import com.assiz.basecep.api.services.PaisService;

@RestController
@RequestMapping("/paises")
@CrossOrigin(origins = "*")
public class PaisController {

	private static final Logger log = LoggerFactory.getLogger(PaisController.class);
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<PaisDto>> listarPorPaisId(
			@PathVariable("id") Integer id) {
		log.info("Buscando pais por ID: {}", id);
		Response<PaisDto> response = new Response<PaisDto>();
		Optional<Pais> pais = paisService.buscarPorId(id);
		
		if (!pais.isPresent()) {
			log.info("Pais não encontrado - ID: {}", id);
			response.getErrors().add("Pais não encontrado - ID " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterPaisDto(pais.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna um DTO com os dados de um cep.
	 * 
	 * @param cep
	 * @return PaisDto
	 */
	private PaisDto converterPaisDto(Pais pais) {
		PaisDto paisDto = new PaisDto();
		paisDto.setId(pais.getId());
		paisDto.setSigla(pais.getSigla());
		paisDto.setPais(pais.getPais());
		paisDto.setEstados(paisRepository.findEstadosByPaisId(pais.getId()));

		return paisDto;
	}
	
}
