package com.assiz.basecep.api.dtos;

import java.util.List;

import com.assiz.basecep.api.interfaces.EstadoInterface;

public class PaisDto {
	
	private Integer id;
	private String sigla;
	private String pais;
	private List<EstadoInterface> estados;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<EstadoInterface> getEstados() {
		return estados;
	}
	public void setEstados(List<EstadoInterface> estados) {
		this.estados = estados;
	}

}
