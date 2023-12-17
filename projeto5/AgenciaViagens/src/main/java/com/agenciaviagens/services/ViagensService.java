package com.agenciaviagens.services;

import java.util.List;

import com.agenciaviagens.models.Viagens;

public interface ViagensService {

	
	List<Viagens> getAllViagens();
	
	Viagens getViagensById(Long id);
	
	Viagens saveViagens(Viagens viagens);
	
	Viagens updateViagens(Long id, Viagens viagensUpdated);
	
	void deleteById(Long id);
	
	void addRelationship(Long viagensId, Long clienteId);

	
	
	
	
	
	
}