package com.assiz.basecep.api.dtos;

import java.util.List;

import com.assiz.basecep.api.interfaces.CidadeInterface;
import com.assiz.basecep.api.interfaces.PaisInterface;

public class EstadoDto {
	
	private Integer id;
	private String sigla;
	private String estado;
	private PaisInterface pais;
	private List<CidadeInterface> cidades;
	

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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public PaisInterface getPais() {
		return pais;
	}
	public void setPais(PaisInterface pais) {
		this.pais = pais;
	}
	public List<CidadeInterface> getCidades() {
		return cidades;
	}
	public void setCidades(List<CidadeInterface> cidades) {
		this.cidades = cidades;
	}

}
