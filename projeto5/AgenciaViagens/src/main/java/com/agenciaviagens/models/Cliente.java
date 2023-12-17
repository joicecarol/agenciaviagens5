package com.agenciaviagens.models;


import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity

public class Cliente {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name="cliente_name", length = 50, nullable = false)
	private String name;
    @Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

    @Column(name = "email", length = 50, nullable = false)
	private String email;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="clientes", fetch = FetchType.EAGER)
	private Set<Viagens> viagens = new HashSet<>();


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


	public Set<Viagens> getViagens() {
		return viagens;
	}


	public void setViagens(Set<Viagens> viagens) {
		this.viagens = viagens;
	}
	

	
	
	public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	
	
}