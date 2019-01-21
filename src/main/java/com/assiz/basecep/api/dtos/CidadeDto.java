package com.assiz.basecep.api.dtos;

import java.util.List;

import com.assiz.basecep.api.interfaces.BairroInterface;
import com.assiz.basecep.api.interfaces.EstadoInterface;
import com.assiz.basecep.api.interfaces.PaisInterface;

public class CidadeDto {
	
	private Integer id;
	private String cidade;
	private EstadoInterface estado;
	private PaisInterface pais;
	private List<BairroInterface> bairros;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public EstadoInterface getEstado() {
		return estado;
	}
	public void setEstado(EstadoInterface estado) {
		this.estado = estado;
	}

	public PaisInterface getPais() {
		return pais;
	}
	public void setPais(PaisInterface pais) {
		this.pais = pais;
	}

	public List<BairroInterface> getBairros() {
		return bairros;
	}
	public void setBairros(List<BairroInterface> bairros) {
		this.bairros = bairros;
	}

}
