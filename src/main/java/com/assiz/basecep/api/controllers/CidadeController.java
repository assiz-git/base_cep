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

import com.assiz.basecep.api.dtos.CidadeDto;
import com.assiz.basecep.api.entities.Cidade;
import com.assiz.basecep.api.entities.Estado;
import com.assiz.basecep.api.repositories.CidadeRepository;
import com.assiz.basecep.api.repositories.EstadoRepository;
import com.assiz.basecep.api.responses.Response;
import com.assiz.basecep.api.services.CidadeService;
import com.assiz.basecep.api.services.EstadoService;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

	private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<CidadeDto>> listarPorCidadeId(
			@PathVariable("id") Integer id) {
		log.info("Buscando cidade por ID: {}", id);
		Response<CidadeDto> response = new Response<CidadeDto>();
		Optional<Cidade> cidade = cidadeService.buscarPorId(id);
		
		if (!cidade.isPresent()) {
			log.info("Cidade não encontrada - ID: {}", id);
			response.getErrors().add("Cidade não encontrada - ID: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterCidadeDto(cidade.get()));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/cidade/{sigla}/{nome}")
	public ResponseEntity<Response<CidadeDto>> listarPorCidadeName(
			@PathVariable("nome") String nome,
			@PathVariable("sigla") String sigla) {
		log.info("Buscando cidade por nome/estado: {}/{}", nome, sigla);
		Response<CidadeDto> response = new Response<CidadeDto>();
		
//		sigla = (sigla + "  ");
//		sigla = sigla.substring(0, 2);
		Optional<Estado> estado = estadoService.buscarPorSigla(sigla);
		
		if (!estado.isPresent()) {
			log.info("Estado não encontrado - estado: {}", sigla);
			response.getErrors().add("Estado não encontrado - estado: " + sigla);
			return ResponseEntity.badRequest().body(response);
		}
		
		Integer estadoId = estado.get().getId();
		
//		nome = (nome + "                                                              ");
//		nome = nome.substring(0, 62);
		Optional<Cidade> cidade = cidadeService.buscarPorCidadeAndEstadoId(nome, estadoId);
		
		if (!cidade.isPresent()) {
			log.info("Cidade não encontrada - nome: {}", nome);
			response.getErrors().add("Cidade não encontrada - nome: " + nome);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterCidadeDto(cidade.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna um DTO com os dados de um cep.
	 * 
	 * @param cidade
	 * @return CidadeDto
	 */
	private CidadeDto converterCidadeDto(Cidade cidade) {
		CidadeDto cidadeDto = new CidadeDto();
		cidadeDto.setId(cidade.getId());
		cidadeDto.setCidade(cidade.getCidade().trim());
		cidadeDto.setEstado(estadoRepository.findByEstadoId(cidade.getEstado().getId()));
		cidadeDto.setBairros(cidadeRepository.findBairrosByCidadeId(cidade.getId()));

		return cidadeDto;
	}
	
}
