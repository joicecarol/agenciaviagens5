package com.agenciaviagens.models;


import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity

public class Viagens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long id;
	
	@Column(name="viagens_nome", length = 50, nullable = false)
	private String name;
	
	
	@Column(name="data_partida" ,nullable = false)
	private LocalDate dataPartida;  

	@Column(name="data_retorno", nullable = false)
	private LocalDate dataRetorno; 
	
	@Column(name="quantidade_pessoas", nullable = false)
	private Integer quantidadePessoas;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="viagens_cliente",
	joinColumns=@JoinColumn(name="viagens_id"),
	inverseJoinColumns=@JoinColumn(name="cliente_id"))
	private Set<Cliente> clientes = new HashSet<>();



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
	public LocalDate getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(LocalDate dataPartida) {
		this.dataPartida = dataPartida;
	}

	public LocalDate getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	
	
	
	
	
	
	

}
