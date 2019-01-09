package com.assiz.basecep.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cep implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cep;
	private String logradouro;
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name="bairro_id")
	private Bairro bairro;

	public Cep() {
	}

	public Cep(String cep, String logradouro, String complemento, Bairro bairro) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
