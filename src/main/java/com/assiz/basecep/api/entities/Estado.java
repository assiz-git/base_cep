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
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String estado;
	private String sigla;
	
	@ManyToOne
	@JoinColumn(name="pais_id")
	private Pais pais;

	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();

	public Estado() {
	}

	public Estado(Integer id, String estado, String sigla, Pais pais) {
		this.id = id;
		this.estado = estado;
		this.sigla = sigla;
		this.pais = pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
