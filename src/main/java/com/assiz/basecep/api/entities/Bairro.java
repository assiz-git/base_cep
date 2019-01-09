package com.assiz.basecep.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bairro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	@JsonIgnore
	@OneToMany(mappedBy="bairro")
	private List<Cep> ceps = new ArrayList<>();

	public Bairro() {
	}


	public Bairro(Integer id, String bairro, Cidade cidade) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public List<Cep> getCeps() {
		return ceps;
	}


	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	}	

}
