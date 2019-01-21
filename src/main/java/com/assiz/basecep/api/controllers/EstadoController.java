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

import com.assiz.basecep.api.dtos.EstadoDto;
import com.assiz.basecep.api.entities.Estado;
import com.assiz.basecep.api.repositories.EstadoRepository;
import com.assiz.basecep.api.repositories.PaisRepository;
import com.assiz.basecep.api.responses.Response;
import com.assiz.basecep.api.services.EstadoService;

@RestController
@RequestMapping("/estados")
@CrossOrigin(origins = "*")
public class EstadoController {

	private static final Logger log = LoggerFactory.getLogger(EstadoController.class);
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<EstadoDto>> listarPorEstadoId(
			@PathVariable("id") Integer id) {
		log.info("Buscando estado por ID: {}", id);
		Response<EstadoDto> response = new Response<EstadoDto>();
		Optional<Estado> estado = estadoService.buscarPorId(id);
		
		if (!estado.isPresent()) {
			log.info("Estado não encontrado - ID: {}", id);
			response.getErrors().add("Estado não encontrado - ID " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterEstadoDto(estado.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna um DTO com os dados de um cep.
	 * 
	 * @param cep
	 * @return EstadoDto
	 */
	private EstadoDto converterEstadoDto(Estado estado) {
		EstadoDto estadoDto = new EstadoDto();
		estadoDto.setId(estado.getId());
		estadoDto.setSigla(estado.getSigla());
		estadoDto.setEstado(estado.getEstado());
		estadoDto.setPais(paisRepository.findByPaisId(estado.getPais().getId()));
		estadoDto.setCidades(estadoRepository.findCidadesByEstadoId(estado.getId()));

		return estadoDto;
	}
	
}
