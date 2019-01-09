package com.assiz.basecep.api.dtos;

import com.assiz.basecep.api.entities.Bairro;

public class CepDto {
	
	private String cep;
	private String logradouro;
	private String complemento;
	private Bairro bairro;
	
	public CepDto() {
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
